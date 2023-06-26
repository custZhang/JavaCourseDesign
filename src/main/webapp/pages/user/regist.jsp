<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <%@ include file="/pages/common/head.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {

            $("#username").blur(function () {
                var username = this.value;
                $.getJSON("user/ajaxExistsUsername", "username=" + username, function (data) {
                    if (data.existUsername) {//存在
                        $("span.errorMsg").text("用户名已存在！");
                    } else {
                        $("span.errorMsg").text("用户名可用");
                    }
                })
            })

            $("#code_img").click(function () {
                // alert("点击了图片");
                //this是当前的dom对象，也就是当前的img标签
                //src就是里面的资源路径，可读可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            })
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                // if (!usernamePatt.test(usernameText)) {
                //     //4 提示用户结果
                //     $("span.errorMsg").text("用户名不合法！");
                //
                //     return false;
                // }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法，组成是5-12位的数字、字母、下划线！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱里的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!(emailText == null || emailText == "" ) && !emailPatt.test(emailText)) {
                    //4 提示用户
                    $("span.errorMsg").text("邮箱格式不合法！");

                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();

                //去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")

                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });

    </script>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background-color: #F5F5F5;
            font-family: Arial, sans-serif;
        }

        .container {
            margin: 30px auto;
            max-width: 500px;
            padding: 30px;
            background-color: #FFF;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.15);
            border-radius: 5px;
            text-align: center;
        }

        h1 {
            font-size: 24px;
            margin-bottom: 30px;
            color: #333;
            font-weight: normal;
            text-align: center;
        }

        form {
            width: 100%;
            margin: 0 auto;
        }

        label {
            display: inline-block;
            font-size: 16px;
            margin-bottom: 5px;
            color: #333;
            text-align: left;
            width: 25%;
        }

        input {
            display: inline-block;
            width: 75%;
            padding: 10px;
            margin: 0;
            font-size: 16px;
            box-sizing: border-box;
            border-radius: 4px;
            border: none;
            background-color: #F7F7F7;
            color: #333;
            outline: none;
            transition: all 0.3s;
        }


        input:focus {
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        button[type=submit] {
            display: inline-block;
            background-color: #2d8cf0;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: all 0.3s;
            margin-top: 20px;
            width: 75%;
            margin-left: 25%;
            box-sizing: border-box;
            text-align: center;
            margin: 0 auto;
            display: block;
        }

        button[type=submit]:hover {
            background-color: #378feb;
        }

        .message {
            color: #f00;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }

        .link {
            margin-top: 20px;
            text-align: right;
            font-size: 14px;
            color: #666;
        }

        .link a {
            text-decoration: none;
            color: #2d8cf0;
            margin-left: 5px;
        }

        .link a:hover {
            text-decoration: underline;
        }

        .errorMsg {
            color: red;
        }

        .form .itxt {
            border: 0 none;
            float: none;
            font-family: "宋体";
            font-size: 14px;
            height: 18px;
            line-height: 18px;
            overflow: hidden;
            padding: 10px 0 10px 10px;
            width: 220px;
            border: 1px #e3e3e3 solid;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>注册</h1>
    <form action="user/regist" method="post">
        <span class="errorMsg">
            ${requestScope.errorMsg}
        </span>
        <br/>
        <input type="hidden" name="action" value="regist">
        <label for="username">用户名</label>
        <input type="text" id="username" name="username" placeholder="请输入用户名" value="${requestScope.username}" required>
        <h5></h5>
        <label for="password">密码</label>
        <input type="password" id="password" name="password" placeholder="请输入密码" value="${requestScope.password}" required>
        <h5></h5>
        <label for="password">确认密码</label>
        <input type="password" id="repwd" name="repwd" placeholder="请再次输入密码" value="${requestScope.repwd}"  required>
        <h5></h5>
        <label for="password">邮箱</label>
        <input type="text" id="email" name="email" placeholder="请输入邮箱（选填）" value="${requestScope.email}" >
        <h5></h5>
        <label>验证码</label>
        <input type="text" id="code" name="code" placeholder="请输入验证码（选填）">
        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:85px;height:35px">
        <h5></h5>
        <div class="message"></div>
        <button type="submit" id="sub_btn">注册</button>
    </form>
    <div class="link">
        <a href="pages/user/login.jsp">已有账号？立即登录</a>
    </div>
</div>
</body>
</html>
