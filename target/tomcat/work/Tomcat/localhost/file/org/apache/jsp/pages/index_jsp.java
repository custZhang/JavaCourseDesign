/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-06-23 10:50:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/pages/common/head.jsp", Long.valueOf(1687504877754L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>文件驿站</title>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $(function () {\n");
      out.write("            // 给删除的 a 标签绑定单击事件，用于删除的确认提示操作\n");
      out.write("            $(\"a.delete-btn\").click(function () {\n");
      out.write("                // 在事件的 function 函数中，有一个 this 对象。这个 this 对象，是当前正在响应事件的 dom 对象。\n");
      out.write("                /**\n");
      out.write("                 * confirm 是确认提示框函数\n");
      out.write("                 * 参数是它的提示内容\n");
      out.write("                 * 它有两个按钮，一个确认，一个是取消。\n");
      out.write("                 * 返回 true 表示点击了，确认，返回 false 表示点击取消。\n");
      out.write("                 */\n");
      out.write("                return confirm(\"你确定要删除【\" + $(this).parent().parent().find(\"td:first\").text() + \"】?\");\n");
      out.write("                // return false// 阻止元素的默认行为===不提交请求\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(\"a.delete-autoLogin\").click(function () {\n");
      out.write("                return confirm(\"删除后，下次使用时将不会自动登录，确定删除吗?\")\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            $(\"a.inbox-btn\").click(function () {\n");
      out.write("                return alert(\"功能开发中，敬请期待\");\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            $(\"a.rename-btn\").click(function () {\n");
      out.write("                const fileNameElem = $(this).parent().parent().find(\"td:first\");//获取fname元素\n");
      out.write("                var oldName = fileNameElem.text();//先保存旧值\n");
      out.write("                fileNameElem.html(\"<input type='text' value='\" + oldName + \"'/>\");//将fname位置更换为输入框\n");
      out.write("\n");
      out.write("                const input = fileNameElem.find('input');//获取输入框\n");
      out.write("                input.focus();//将光标聚集在文本输入框上\n");
      out.write("                input[0].selectionStart = 0;\n");
      out.write("                input[0].selectionEnd = oldName.lastIndexOf(\".\");\n");
      out.write("\n");
      out.write("                //用户按回车，调用失去焦点事件\n");
      out.write("                input.on(\"keydown\", function(event) {\n");
      out.write("                    if (event.which === 13) { // 如果按下的是回车键\n");
      out.write("                        input.blur(); // 手动触发 \"blur\" 事件\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                // 当用户完成输入后，向file提交新的文件名\n");
      out.write("                input.blur(function () {\n");
      out.write("                    const newName = input.val().trim();\n");
      out.write("                    if (newName === '' || newName === oldName) {\n");
      out.write("                        // 如果文件名为空或没有修改，则不做任何更改\n");
      out.write("                        fileNameElem.html(oldName);\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                    // 发送重命名请求\n");
      out.write("                    window.location.href = \"file/rename?oldName=\" + oldName + \"&newName=\" + newName;\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        function submitForm() {\n");
      out.write("            const form = document.getElementById('upload-form');\n");
      out.write("            form.submit();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        /* 页面整体样式 */\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            position: relative;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* 左边栏样式 */\n");
      out.write("        #left-bar {\n");
      out.write("            position: fixed;\n");
      out.write("            left: 0;\n");
      out.write("            top: 0;\n");
      out.write("            bottom: 0;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: #F4F4F4;\n");
      out.write("            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);\n");
      out.write("\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            justify-content: flex-end;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar a {\n");
      out.write("            display: block;\n");
      out.write("            color: #333;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            background-color: #EEE;\n");
      out.write("            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);\n");
      out.write("            transition: background-color 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar a:hover {\n");
      out.write("            background-color: #DDD;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #file-btn {\n");
      out.write("            /*background-image: url(\"file_icon.png\");*/\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-position: left 5px center;\n");
      out.write("            background-size: 20px;\n");
      out.write("            padding-left: 30px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #inbox-btn {\n");
      out.write("            /*background-image: url(\"inbox_icon.png\");*/\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-position: left 5px center;\n");
      out.write("            background-size: 20px;\n");
      out.write("            padding-left: 30px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #note-btn {\n");
      out.write("            /*background-image: url(\"inbox_icon.png\");*/\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-position: left 5px center;\n");
      out.write("            background-size: 20px;\n");
      out.write("            padding-left: 30px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #logout-btn {\n");
      out.write("            /*background-image: url(\"logout_icon.png\");*/\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-position: left 5px center;\n");
      out.write("            background-size: 20px;\n");
      out.write("            padding-left: 30px;\n");
      out.write("            margin-top: auto;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        #left-bar #user-info {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #user-info img {\n");
      out.write("            width: 100px;\n");
      out.write("            height: 100px;\n");
      out.write("            border-radius: 50%;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #user-info #nickname {\n");
      out.write("            font-size: 18px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #left-bar #user-info #user-id {\n");
      out.write("            font-size: 14px;\n");
      out.write("            color: #666;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* 右边栏样式 */\n");
      out.write("        #right-container {\n");
      out.write("            margin-left: 140px;\n");
      out.write("            padding: 40px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #right-bar {\n");
      out.write("            background-color: #FFF;\n");
      out.write("            padding: 20px;\n");
      out.write("            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn {\n");
      out.write("            display: inline-block;\n");
      out.write("            background-color: #007AFF;\n");
      out.write("            color: #FFF;\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            transition: background-color 0.3s;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn:hover {\n");
      out.write("            background-color: #0065FF;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #new-btn {\n");
      out.write("            float: right;\n");
      out.write("            padding: 10px 30px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #newBtn {\n");
      out.write("            float: right;\n");
      out.write("            padding: 10px 30px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.download-btn, a.delete-btn, a.rename-btn {\n");
      out.write("            display: inline-block;\n");
      out.write("            color: #FFF;\n");
      out.write("            padding: 5px 10px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            transition: background-color 0.3s;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.download-btn {\n");
      out.write("\n");
      out.write("            background-color: cornflowerblue;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.download-btn:hover {\n");
      out.write("            background-color: #007AFF;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.delete-btn {\n");
      out.write("\n");
      out.write("            background-color: lightcoral;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.delete-btn:hover {\n");
      out.write("            background-color: #FF3B30;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.rename-btn {\n");
      out.write("            background-color: #FF9500;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a.rename-btn:hover {\n");
      out.write("            background-color: #E68100;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("            border-bottom: 1px solid #EEE;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #EEE;\n");
      out.write("            font-weight: normal;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        td:last-child {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #notice {\n");
      out.write("            background-color: #EEE;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .bottom {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"left-bar\">\n");
      out.write("    <div id=\"user-info\">\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("    <a id=\"logout-btn\" href=\"user/logout\">退出</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"right-container\">\n");
      out.write("    <div id=\"right-bar\">\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        <p>已用空间：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser == null ? \"0.0\" : sessionScope.loginUser.currentSize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("MB/\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser == null ? \"114.51\" : sessionScope.loginUser.maxSize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("MB</p>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>文件名</th>\n");
      out.write("                <th>大小</th>\n");
      out.write("                <th>日期</th>\n");
      out.write("                <th>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;操作</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <div id=\"notice\"><h3>公告</h3>\n");
      out.write("            <p>\n");
      out.write("                欢迎使用。\n");
      out.write("                <br/>\n");
      out.write("                <br/>\n");
      out.write("                <a href=\"static/img/tutorial.jpg\" target=\"_blank\">手机端上传文件教程</a>\n");
      out.write("                <br/>\n");
      out.write("                <a class=\"delete-autoLogin\" href=\"user/deleteAutoLogin\">删除已保存的7天免登录信息</a>\n");
      out.write("                <br/>\n");
      out.write("                <br/>\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.notice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"bottom\">\n");
      out.write("        <p>version:1.0</p>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /pages/index.jsp(279,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <a href=\"pages/user/login.jsp\">\n");
        out.write("                <img src=\"static/img/default_picture.png\">\n");
        out.write("            </a>\n");
        out.write("            <div id=\"nickname\"><a href=\"pages/user/login.jsp\">点击登录</a></div>\n");
        out.write("            <div id=\"user-id\"><a href=\"pages/user/login.jsp\">UID:00000</a></div>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /pages/index.jsp(286,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <img src=\"static/img/default_picture.png\">\n");
        out.write("            <div id=\"nickname\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</div>\n");
        out.write("            <div id=\"user-id\">UID: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</div>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /pages/index.jsp(292,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <a id=\"file-btn\" href=\"pages/user/login.jsp\">首页</a>\n");
        out.write("        <a id=\"note-btn\" href=\"pages/user/login.jsp\">笔记本</a>\n");
        out.write("        <a id=\"inbox-btn\" class=\"inbox-btn\">收件箱</a>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /pages/index.jsp(297,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <a id=\"file-btn\" href=\"user/homepage\">首页</a>\n");
        out.write("        <a id=\"note-btn\" href=\"note/read\">笔记本</a>\n");
        out.write("        <a id=\"inbox-btn\" class=\"inbox-btn\">收件箱</a>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /pages/index.jsp(308,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <a class=\"btn\" id=\"newBtn\" href=\"pages/user/login.jsp\">上传</a>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f5.setParent(null);
    // /pages/index.jsp(311,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.loginUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
    if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <form action=\"file/upload\" method=\"post\" enctype=\"multipart/form-data\" id=\"upload-form\">\n");
        out.write("                <label for=\"new-btn\" class=\"btn\" id=\"newBtn\">上传</label>\n");
        out.write("                <input type=\"file\" id=\"new-btn\" name=\"file\" onchange=\"submitForm()\" style=\"display: none;\">\n");
        out.write("            </form>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /pages/index.jsp(327,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/pages/index.jsp(327,12) '${sessionScope.files}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${sessionScope.files}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /pages/index.jsp(327,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("file");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <tr>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.fname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.fsize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("MB</td>\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.updatetime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                    <td>\n");
          out.write("                        <a href=\"file/download?downloadFName=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.fname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"download-btn\">下载</a>\n");
          out.write("                        <a href=\"file/delete?deleteFName=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.fname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("&deleteFSize=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.fsize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"\n");
          out.write("                           class=\"delete-btn\">删除</a>\n");
          out.write("                        <a class=\"rename-btn\">重命名</a>\n");
          out.write("                    </td>\n");
          out.write("                </tr>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}