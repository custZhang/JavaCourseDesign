<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <%@ include file="/pages/common/head.jsp"%>
    <meta name="viewport" content="width=device-width, in   itial-scale=1.0">

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

        p{
            color:red;
        }

        .autoLogin{
            width: auto;
            height: auto;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>登录</h1>
    <form action="user/login" method="post">
        <p>${requestScope.errorMsg}</p>
        <label for="username">用户名/UID</label>
        <input type="text" id="username" name="username" placeholder="请输入用户名/UID"  required>
        <h5></h5>
        <label for="password">密码</label>
        <input type="password" id="password" name="password" placeholder="请输入密码" required>
        <h5></h5>
        <input type="checkbox" name="login" value="autoLogin" class="autoLogin"/> 7天内自动登录
        <h5></h5>
        <div class="message"></div>
        <button type="submit">登录</button>
    </form>
    <div class="link">
        <a href="pages/user/regist.jsp">还没有账号？立即注册</a>
    </div>
</div>
</body>
</html>
