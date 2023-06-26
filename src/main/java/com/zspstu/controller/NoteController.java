package com.zspstu.controller;

import com.zspstu.utils.GetPathUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/note")
public class NoteController {

    @RequestMapping("/test")
    @ResponseBody
    public String save() {
        return "NoteController/save() is running...";
    }

    @RequestMapping("/save")
    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("到达note的save方法");
        //获取参数
        String content = req.getParameter("content");//用户写入的内容
        int userUid = (int)req.getSession().getAttribute("userUid");
        String notePath = GetPathUtils.get("notePath") + userUid + ".txt";//该用户的txt文件路径
        //将content写入文件
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(notePath, false));
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        //获取当前时间，保存到req中

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = dtf.format(LocalTime.now());
        String msg = "已保存(" + time + ")";
//        req.setAttribute("msg",msg);
        req.getSession().setAttribute("msg",msg);
        //请求重定向回note页面，避免刷新时重复提交
        resp.sendRedirect(req.getContextPath()+ "/note/read");

//        //请求重定向回去后，仍能获取参数
//        Map<String, Object> result = new HashMap();
//        result.put("save", true);
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(result);
//        resp.getWriter().write(jsonStr);
//        resp.sendRedirect(req.getContextPath()+ "/pages/note.jsp");
    }

    @RequestMapping("/read")
    public void read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //从磁盘中读取该用户的txt，写入到content中
        int userUid = (int)req.getSession().getAttribute("userUid");
        String notePath = GetPathUtils.get("notePath") + userUid + ".txt";
        BufferedReader br = null;
        String content = "";//用来读取文件里的全部内容
        String line;//用来临时保存每次读取一行的内容
        try {
            br = new BufferedReader(new FileReader(notePath));
            while ((line = br.readLine()) != null){
                content = content + line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("note",content);
        req.getRequestDispatcher("/pages/note.jsp").forward(req,resp);
    }
}
