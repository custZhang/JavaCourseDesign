/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-06-23 07:21:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/pages/common/head.jsp", Long.valueOf(1687504877754L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>登录</title>\r\n");
      out.write("    ");
      out.write('\r');
      out.write('\n');

    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/"
            ;
    pageContext.setAttribute("basePath",basePath);

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<base href= \"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"static/script/jquery-1.7.2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, in   itial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        body {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background-color: #F5F5F5;\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("            max-width: 500px;\r\n");
      out.write("            padding: 30px;\r\n");
      out.write("            background-color: #FFF;\r\n");
      out.write("            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.15);\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h1 {\r\n");
      out.write("            font-size: 24px;\r\n");
      out.write("            margin-bottom: 30px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            font-weight: normal;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        form {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            text-align: left;\r\n");
      out.write("            width: 25%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            width: 75%;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            background-color: #F7F7F7;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            outline: none;\r\n");
      out.write("            transition: all 0.3s;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input:focus {\r\n");
      out.write("            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button[type=submit] {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            background-color: #2d8cf0;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: all 0.3s;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            width: 75%;\r\n");
      out.write("            margin-left: 25%;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            display: block;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button[type=submit]:hover {\r\n");
      out.write("            background-color: #378feb;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .message {\r\n");
      out.write("            color: #f00;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .link {\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            text-align: right;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("            color: #666;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .link a {\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            color: #2d8cf0;\r\n");
      out.write("            margin-left: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .link a:hover {\r\n");
      out.write("            text-decoration: underline;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        p{\r\n");
      out.write("            color:red;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .autoLogin{\r\n");
      out.write("            width: auto;\r\n");
      out.write("            height: auto;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <h1>登录</h1>\r\n");
      out.write("    <form action=\"user/login\" method=\"post\">\r\n");
      out.write("        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.errorMsg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("        <label for=\"username\">用户名/UID</label>\r\n");
      out.write("        <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"请输入用户名/UID\"  required>\r\n");
      out.write("        <h5></h5>\r\n");
      out.write("        <label for=\"password\">密码</label>\r\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"请输入密码\" required>\r\n");
      out.write("        <h5></h5>\r\n");
      out.write("        <input type=\"checkbox\" name=\"login\" value=\"autoLogin\" class=\"autoLogin\"/> 7天内自动登录\r\n");
      out.write("        <h5></h5>\r\n");
      out.write("        <div class=\"message\"></div>\r\n");
      out.write("        <button type=\"submit\">登录</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    <div class=\"link\">\r\n");
      out.write("        <a href=\"pages/user/regist.jsp\">还没有账号？立即注册</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
