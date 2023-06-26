package com.zspstu.controller;

import com.zspstu.domain.User;
import com.zspstu.service.FileService;
import com.zspstu.service.impl.FileServiceImpl;
import com.zspstu.utils.DateUtils;
import com.zspstu.utils.GetPathUtils;
import com.zspstu.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    private ServletConfig servletConfig;

    @RequestMapping("/test")
    @ResponseBody
    public String save() {
        return "FileController/save() is running...";
    }

    @RequestMapping("/upload")
    public void upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("到达upload");
        int userUid = (int)req.getSession().getAttribute("userUid");
        //先判断是不是多段上传
        if(ServletFileUpload.isMultipartContent(req)){
            //创建工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用来解析上传数据的ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //将请求req里上传的数据解析，结果是每一个input生成一个表单项放在集合里
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //一次提交会提交多种类型的input，要区分是普通表单项还是文件表单项
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){//普通表单项
                    }else{//文件表单项
                        //input标签里的name值
                        System.out.println("表单项里的name属性值" + fileItem.getFieldName());//文件类型
                        //上传的文件名
                        System.out.println("上传的文件名是" + fileItem.getName());
                        //上传的文件大小
                        double fileSize = (double)fileItem.getSize() / (1024 * 1024);
                        String fileName = fileItem.getName();
                        System.out.println("上传的文件大小为" + fileItem.getSize());

                        //判断有没有同名，没有就直接上传
                        //有的话查找带有括号的，如果最后查找结果个数为0，就直接在后面加上(1)
                        if(fileService.fileExsit(userUid,fileName)){//找到就返回true
                            fileName = findNewName(userUid,fileName);
                        }
                        //没进入if就说明在file表里找不到同名文件，则直接用原文件名上传

                        //判断用户上传的文件大小，是不是超过了容量(用户的当前容量 + 此次上传的文件大小 > 最大容量，就不能上传)
                        //改为只要现在的容量没有超过最大容量，就允许上传
                        User loginUser = (User)req.getSession().getAttribute("loginUser");
                        if(loginUser.getCurrentSize() > loginUser.getMaxSize()){
                            resp.sendRedirect(req.getContextPath()+ "/pages/error/uploadError.jsp");
                            return;
                        }

                        //改为注册时创建
                        //判断路径是否存在，不存在就创建
                        String dirPath = GetPathUtils.get("filePath") + userUid;//该用户的文件夹
//                        File dir = new File(dirPath);
//                        if(!dir.exists()){
//                            dir.mkdirs();
//                        }

                        //将上传的文件，写入到磁盘
                        fileItem.write(new File(dirPath + "//" + fileName));

                        //file表存数据
                        fileService.addFile(new com.zspstu.domain.File(
                                null,fileName,fileSize,
                                DateUtils.getCurrentDate(),dirPath + "//",userUid));
                        //修改user表的存储空间
                        double changeSize = fileSize;
                        req.setAttribute("changeSize",changeSize);
                        req.getRequestDispatcher("/user/changeSize").forward(req,resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //download里的值就是当前文件名，在前面拼接上用户uid
        int userUid = (int)req.getSession().getAttribute("userUid");

//        String fileName = WebUtils.readString(req, "downloadFName");
        //服务器不需要转
        String fileName = req.getParameter("downloadFName");

        String dirPath = GetPathUtils.get("filePath") + userUid + "//";//该用户的文件夹
        //1.先保存要下载的文件名
        //2.要读取这个文件，可以使用ServletContext读取
//        ServletContext servletContext = getServletContext();
        ServletContext servletContext = req.getServletContext();
        //3.在回传前，通过响应头告诉客户端返回的数据类型
        //参数填的是文件路径，然后自动识别类型为mimeType
        String mimeType = servletContext.getMimeType(dirPath + fileName);

        System.out.println("要下载的文件类型是" + mimeType);
        //通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //4.告诉客户端收到的数据怎么使用
        if(req.getHeader("User-Agent").contains("Firefor")){//如果是火狐浏览器，使用Base64编码
            resp.setHeader("Content-Disposition",
                    "attachment;filename==?UTF-8?B?" +
                            new BASE64Encoder().encode(fileName.getBytes("UTF-8")) + "?=");
        }else{//如果是其他浏览器，使用URL编码
            resp.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        }

        //将文件解析成InputStream
        FileInputStream inputStream = new FileInputStream(new File(dirPath + fileName));
        //获取resp的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //将下载的文件回传给客户端
        IOUtils.copy(inputStream,outputStream);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.删除磁盘文件
        int userUid = (int)req.getSession().getAttribute("userUid");
        String fileName = req.getParameter("deleteFName");
        String filePath = GetPathUtils.get("filePath");
        File file = new File(filePath + userUid + "//" + fileName);
        file.delete();
        //2.删除file表记录
        fileService.deleteFile(fileName,userUid);
        //3.user表剩余空间增加(伴随跳转到主页)
        String deleteFSize = req.getParameter("deleteFSize");
        double changeSize = 0 - Double.parseDouble(deleteFSize);
        req.setAttribute("changeSize",changeSize);
        req.getRequestDispatcher("/user/changeSize").forward(req,resp);
    }

    @RequestMapping("/homepage")
    public void homepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //根据session中存放的userUid，在file表中找到该uid的所有文件
        int userUid = (int)req.getSession().getAttribute("userUid");
        List<com.zspstu.domain.File> files = fileService.queryFilesByUid(userUid);
        //找到的文件files存放到session中
        req.getSession().setAttribute("files",files);
        //这里得用请求重定向，用户多次刷新才有效
        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }


    @RequestMapping("/rename")
    public void rename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("到达rename方法");
        int userUid = (int)req.getSession().getAttribute("userUid");

//        String oldName = WebUtils.readString(req, "oldName");
//        String newName = WebUtils.readString(req, "newName");
        //服务器不需要转
        String oldName = req.getParameter("oldName");
        String newName = req.getParameter("newName");

        //更改磁盘里的文件名
        String filePath = GetPathUtils.get("filePath");//D://temp//FileDisk//
        File oldNameFile = new File(filePath + userUid + "//" + oldName);
        File newNameFile = new File(filePath + userUid + "//" + newName);
        oldNameFile.renameTo(newNameFile);
        //更改file表里的fname
        fileService.updateFname(userUid,oldName,newName);
        //重定向回homepage
        resp.sendRedirect(req.getContextPath()+ "/user/homepage");
    }


    public String findNewName(int uid,String uploadName){
        //对于在这里查不到的，都是文件里已有重名的，在这里还查不到的话，就直接在后面加（1）
        // （就相当于上传实验三，已有实验三，而在这里（数据库）找不到实验三(1)，所以在后面加(1)），
        //目的是为了找到”实验三(数字).docx“的所有文件，然后由最大的+1，得到新的文件名
        //接下来举例uploadName是"实验三.docx"，假设已有(1)”实验三.jpg“,(2)”实验三Java.docx“,(3)"实验三(测试).docx"，(4)"实验三(11),docx"
        //suffix n.后缀
        FileService fileService = new FileServiceImpl();
        //1.先将文件名后缀剪切，得到不含后缀名的文件名nameNonSuffix，以及后缀suffix
        int pointIndex = uploadName.lastIndexOf(".");//点的位置
        String nameNonSuffix = uploadName.substring(0,pointIndex);//不带后缀的文件名
        String suffix = uploadName.substring(pointIndex + 1);//文件名的后缀
        //2.在数据库里查找以 nameNonSuffix (%) . suffix 的文件，得到list集合（排除了类似(1)后缀名不相同的文件,以及(2)的这种文件）
        //不直接使用  nameNonSuffix (_) . suffix 是因为可能括号里的数字是两位数比如(4)
        String vagueFindName = nameNonSuffix + "(%)." + suffix;//模糊查找的名字
        List<com.zspstu.domain.File> files = fileService.queryFnameVague(uid, vagueFindName);
        //首次查找出files，以及之后每次删除，都要去判断files是否为空，为空就直接在后面加(1)
        if(files.isEmpty()){
            return nameNonSuffix + "(1)." + suffix;
        }
        //3.使用正则表达式，只找出 % 的位置是数字的文件（即删去集合里不是这种形式的文件），顺便保留这个数字num(排除了类似(3)这种括号里不是数字的文件)
        //% 处的数字只允许是1-99，因为可能有人在此位置填学号等信息，而且一般用户上传的文件版本迭代也不会超过99
        String regStr = "^" + nameNonSuffix + "\\((\\d{1}|\\d{2})\\)\\." + suffix + "$";
        //删除括号里非数字的
        for(int i = 0;i < files.size();i++){
            if(!files.get(i).getFname().matches(regStr)){
                files.remove(i);
            }
        }
        //首次查找出files，以及之后每次删除，都要去判断files是否为空，为空就直接在后面加(1)
        if(files.isEmpty()){
            return nameNonSuffix + "(1)." + suffix;
        }
        //4.在删去后的集合里，找到集合里最数字最大的文件(不一定是集合里最后一个，因为可能用户先上传了”实验三(3).docx“再上传了”实验三(2).docx“)
        //pointIndex是点的位置，则pointIndex - 1就是右括号的位置，而左括号的位置可能是pointIndex - 3 或 pointIndex - 4
        int maxIndex = 0;
        for (com.zspstu.domain.File file :files) {
            String fname = file.getFname();
            //取出括号里的数字，放到index里
            int index = 0;
            int currentPointIndex = fname.lastIndexOf(".");//每个文件名的点的下标都和上传文件的点的下标不相同
            if(fname.charAt(currentPointIndex - 3) == '('){//下标是1-9
                index = Integer.parseInt(fname.substring(currentPointIndex - 2,currentPointIndex - 1));
            }else if(fname.charAt(currentPointIndex - 4) == '('){//下标是10-99
                index = Integer.parseInt(fname.substring(currentPointIndex - 3,currentPointIndex - 1));
            }
            //找到最大的数字，放到maxIndex里
            if(index > maxIndex){
                maxIndex = index;
            }
        }
        //5.该文件数字部分+1,就是新文件名
        String newFileName = nameNonSuffix + "(" + (maxIndex + 1) + ")." + suffix;
        System.out.println(newFileName);
        return newFileName;
    }
}
