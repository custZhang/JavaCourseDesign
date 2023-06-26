package com.zspstu.controller;

import com.google.gson.Gson;
import com.zspstu.domain.User;
import com.zspstu.service.UserService;
import com.zspstu.utils.CookieUtils;
import com.zspstu.utils.GetPathUtils;
import com.zspstu.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String save() {
        return "UserController/save() is running...";
    }

    @RequestMapping("/regist")
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");

        //获取图片上验证码的值
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //立即删掉，让重复提交时获取不到这个token
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");
        //2.检查验证码是否正确
        if (token != null && !token.equalsIgnoreCase(code)) {
            //不正确  跳回注册页面
            req.setAttribute("errorMsg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("repwd", repwd);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            return;
        }
        //如果执行到这里，说明验证码正确
        //正确    3.检查用户名是否可用
        if (this.userService.existUsername(username)) {
            //则用户名已存在
            //不可用  跳回注册页面
            req.setAttribute("errorMsg", "该用户名已存在");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("repwd", repwd);
            req.setAttribute("email", email);
            System.out.println("用户名【" + username + "】已存在");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        } else {
            //可用，上传到服务器
            User user = new User(null, username, password, email, 0, 114.51);
            int regist = userService.regist(user);
            //查询uid
            int uid = userService.findUid(username);
            //创建filePath/uid文件夹
            File filePath = new File(GetPathUtils.get("filePath") + uid);
            filePath.mkdir();
            //创建uid.txt用于存放note的文件
            File notePath = new File(GetPathUtils.get("notePath") + uid + ".txt");
            notePath.createNewFile();

            req.getSession().setAttribute("loginUser", user);
            //跳转到注册成功页面
            resp.sendRedirect(req.getContextPath() + "/pages/user/regist_success.jsp");
        }
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        String password;
        User autoLoginUser = (User) req.getSession().getAttribute("loginUser");
        if (autoLoginUser != null) {//自动登录方式获取username和password
            username = autoLoginUser.getUsername();
            password = autoLoginUser.getPassword();
        } else {//普通的前端提交表单方式获取username和password
            username = req.getParameter("username");
            password = req.getParameter("password");
        }

        long begin = System.currentTimeMillis();
        User loginUser = userService.login(username, password);
        long end = System.currentTimeMillis();
        System.out.println("UserService.login()执行的时间是" + (end - begin));


        if (loginUser == null) {//账号或密码错误
            req.setAttribute("errorMsg", "账号或密码错误");
            req.setAttribute("username", username);
            System.out.println("用户名[" + username + "]或密码[" + password + "]错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else { //登录成功
            System.out.println("用户【" + username + "】已登录");
            req.getSession().setAttribute("loginUser", loginUser);
            req.getSession().setAttribute("userUid", loginUser.getUid());

            //若用户勾选了自动登录
            String[] logins = req.getParameterValues("login");
            if (logins != null && logins[0].equals("autoLogin")) {//则说明用户勾选了自动登录
                String encodedUsername = URLEncoder.encode(username, "UTF-8");
                String encodedPassword = URLEncoder.encode(password, "UTF-8");

                Cookie cUsername = new Cookie("username", encodedUsername);
                Cookie cPassword = new Cookie("password", encodedPassword);
                //设置保存到/file之后，意思就是只要访问/file及其子目录都能获取到cookie
                cUsername.setPath(req.getContextPath());
                cPassword.setPath(req.getContextPath());
                cUsername.setMaxAge(60 * 60 * 24 * 7);//单位是秒
                cPassword.setMaxAge(60 * 60 * 24 * 7);//单位是秒
                resp.addCookie(cUsername);
                resp.addCookie(cPassword);
            }
            //每次跳转到主页都是先跳转到/user/homepage，这里虽然不需要/user/homepage里重新查询，但是也统一一下
            resp.sendRedirect(req.getContextPath() + "/user/homepage");

//            resp.sendRedirect(req.getContextPath() + "/file/homepage");
        }
    }

    @RequestMapping("/homepage")
    public void homepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里要重新获取一次user对象，因为可能currentSize发生改变
        int userUid = (int)req.getSession().getAttribute("userUid");
        User newUser = userService.findById(userUid);
        req.getSession().setAttribute("loginUser",newUser);
        req.getRequestDispatcher("/file/homepage").forward(req,resp);
    }

    @RequestMapping("/changeSize")
    public void changeSize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userUid = (int)req.getSession().getAttribute("userUid");
        User loginUser = (User)req.getSession().getAttribute("loginUser");
        //添加文件时，传过来的changeSize是正数；删除文件时，传过来的changeSize是负数
        double changeSize = (double)req.getAttribute("changeSize");
        //用该账户原来的空间，加上changeSize，就得到新的空间
        double newSize = loginUser.getCurrentSize() + changeSize;
        int i = userService.changeSize(userUid, newSize);
        //通过user.homepage跳转回主页
//        req.getRequestDispatcher("/file/homepage").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+ "/user/homepage");
    }

    @RequestMapping("/ajaxExistsUsername")
    public void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器不需要转
        String username = req.getParameter("username");
//        String username = WebUtils.readString(req, "username");
        boolean existUsername = this.userService.existUsername(username);
        Map<String, Object> result = new HashMap();
        result.put("existUsername", existUsername);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(result);
        resp.getWriter().write(jsonStr);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除所有，只保留notice
        HttpSession session = req.getSession();
        String notice = (String)session.getAttribute("notice");
        req.getSession().invalidate();

        req.getSession().setAttribute("notice",notice);
        resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
    }

    @RequestMapping("/autoLogin")
    public void autoLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载公告
        Properties properties = new Properties();
        InputStream resourceAsStream = UserController.class.getResourceAsStream("/notice.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, "UTF-8");
        properties.load(inputStreamReader);
        String notice = properties.getProperty("notice");
        req.getSession().setAttribute("notice",notice);

        //用户在10分钟内自动登录
        User user = (User) req.getSession().getAttribute("loginUser");

        //7天免登录：如果cookie中有用户信息，取出生成User放到session中的loginUser中
        //session域中的数据优先，如果session和cookie中有同时用户名密码，就使用session中的登录
        if(user == null && req.getCookies() != null){
            Cookie cUsername = CookieUtils.findCookie("username", req.getCookies());
            Cookie cPassword = CookieUtils.findCookie("password", req.getCookies());
            //如果用户打开浏览器后，第二次访问/index，则cookies里会保存一个JSESSIONID
            //而并没有cUsername和cPassword，所以不能使用cookie自动登录,就直接跳转回主页
            if(cUsername == null || cPassword == null){
                resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
                return;
            }
            String username = cUsername.getValue();
            username = URLDecoder.decode(username,"UTF-8");
            String password = cPassword.getValue();
            user = new User(null,username,password);
            req.getSession().setAttribute("loginUser",user);
        }

        //检查有无sessionScope，有就调用login方法
        if(user != null){
            //将username和password保存到req里，在login方法里才能获取到
//            req.setAttribute("username",user.getUsername());
//            req.setAttribute("password",user.getPassword());
            req.getRequestDispatcher("/user/login").forward(req,resp);
        }else{//没有就跳转到pages/index.jsp
            resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
        }
    }

    @RequestMapping("/deleteAutoLogin")
    public void deleteAutoLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除用于登录的cookie
        Cookie cUsername = CookieUtils.deleteCookie("username", req.getCookies());
        Cookie cPassword = CookieUtils.deleteCookie("password", req.getCookies());


        if(cUsername != null){
            cUsername.setPath(req.getContextPath());
            resp.addCookie(cUsername);
        }
        if(cPassword != null){
            cPassword.setPath(req.getContextPath());
            resp.addCookie(cPassword);
        }
        if(req.getSession().getAttribute("loginUser") == null){
            resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
            return;
        }
        resp.sendRedirect(req.getContextPath()+ "/user/homepage");
    }
}
