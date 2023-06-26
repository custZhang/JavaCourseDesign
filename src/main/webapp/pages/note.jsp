<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文件驿站</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {

            $("a.inbox-btn").click(function () {
                return alert("功能开发中，敬请期待");
            })

            $("a#copyBtn").click(function () {
                var textarea = document.getElementById("content"); // 通过 id 获取 TextArea 元素
                textarea.select(); // 选中该元素中的所有文本
                document.execCommand("copy"); // 将选中的文本复制到剪贴板中
                // var isCopy = true;//标记此次是复制操作
                $("p.msg").text("已复制");
            })

            $("a#saveBtn").click(function () {
                var elementById = document.getElementById("submit");
                elementById.click();
            })


            // $("#content").on("blur", function () {
            //     alert("到达onblur方法");
            //     alert("iscopy:" + isCopy);
            //     // 点击复制按钮后的第一次失去焦点事件,不会自动提交
            //     if(!isCopy){
            //         //获取textarea里的内容，提交
            //         var elementById = document.getElementById("submit");
            //         elementById.click();
            //     }else{
            //         isCopy = false;
            //     }
            // });

            $("#content").on("blur", function () {
                // alert("到达onblur方法");
                $("#submit").click();
            });

        })

    </script>
    <style type="text/css">
        /* 页面整体样式 */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            position: relative;
        }

        /* 左边栏样式 */
        #left-bar {
            position: fixed;
            left: 0;
            top: 0;
            bottom: 0;
            padding: 20px;
            background-color: #F4F4F4;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);

            display: flex;
            flex-direction: column;
            justify-content: flex-end;
        }

        #left-bar a {
            display: block;
            color: #333;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            text-decoration: none;
            background-color: #EEE;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s;
        }

        #left-bar a:hover {
            background-color: #DDD;
        }

        #left-bar #file-btn {
            background-image: url("file_icon.png");
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
        }

        #left-bar #inbox-btn {
            background-image: url("inbox_icon.png");
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
            cursor: pointer;
        }

        #left-bar #note-btn {
            background-image: url("inbox_icon.png");
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
            cursor: pointer;
        }

        #left-bar #logout-btn {
            background-image: url("logout_icon.png");
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
            margin-top: auto;
        }


        #left-bar #user-info {
            margin-bottom: 20px;
        }

        #left-bar #user-info img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            margin-bottom: 10px;
        }

        #left-bar #user-info #nickname {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        #left-bar #user-info #user-id {
            font-size: 14px;
            color: #666;
            margin-bottom: 10px;
        }

        /* 右边栏样式 */
        #right-container {
            margin-left: 140px;
            padding: 40px;
        }

        #right-bar {
            background-color: #FFF;
            padding: 20px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
            border-radius: 5px;
        }

        .btn {
            display: inline-block;
            background-color: #007AFF;
            color: #FFF;
            padding: 10px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s;
            margin-bottom: 10px;
            margin-right: 14px;
            float: right;
            padding: 10px 30px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #0065FF;
        }

        #refreshBtn{
            background-color: #378feb;
        }

        #refreshBtn:hover{
            background-color: #0065FF;
        }

        #saveBtn{
            background-color: mediumblue;
        }

        #saveBtn:hover{
            background-color: navy;
        }

        #content {
            margin-top: 8px;
            font-size: 16px;
        }

        p {
            margin-bottom: 10px;
            color: red;
            font-size: 18px;
        }
        .bottom {
            text-align: center;
        }

    </style>
</head>
<body>
<div id="left-bar">
    <div id="user-info">
        <c:if test="${empty sessionScope.loginUser}">
            <a href="pages/user/login.jsp">
                <img src="static/img/default_picture.png">
            </a>
            <div id="nickname"><a href="pages/user/login.jsp">点击登录</a></div>
            <div id="user-id"><a href="pages/user/login.jsp">UID:00000</a></div>
        </c:if>
        <c:if test="${not empty sessionScope.loginUser}">
            <img src="static/img/default_picture.png">
            <div id="nickname">${sessionScope.loginUser.username}</div>
            <div id="user-id">UID: ${sessionScope.loginUser.uid}</div>
        </c:if>
    </div>
    <c:if test="${empty sessionScope.loginUser}">
        <a id="file-btn" href="pages/user/login.jsp">首页</a>
        <a id="note-btn" href="pages/user/login.jsp">笔记本</a>
        <a id="inbox-btn" class="inbox-btn">收件箱</a>
    </c:if>
    <c:if test="${not empty sessionScope.loginUser}">
        <a id="file-btn" href="user/homepage">首页</a>
        <a id="note-btn" href="note/read">笔记本</a>
        <a id="inbox-btn" class="inbox-btn">收件箱</a>
    </c:if>

    <a id="logout-btn" href="user/logout">退出</a>
</div>

<div id="right-container">
    <div id="right-bar">
        <c:if test="${empty sessionScope.loginUser}">

            <a class="btn" id="saveBtn" href="pages/user/login.jsp">保存</a>
            <a class="btn" id="copyBtn">复制</a>
            <a class="btn" id="refreshBtn" href="note/read">刷新</a>
        </c:if>
        <c:if test="${not empty sessionScope.loginUser}">
            <a class="btn" id="saveBtn">保存</a>
            <a class="btn" id="copyBtn">复制</a>
            <a class="btn" id="refreshBtn" href="note/read">刷新</a>
        </c:if>
        <p class="msg">
            ${sessionScope.msg}
<%--            只输出一次，然后就删掉--%>
            <c:set scope="session" var="msg" value=""/>
        </p>
        <form action="note/save" method="post">
            <textarea id="content" name="content" rows="30" cols="150" placeholder="在此输入内容">${requestScope.note}</textarea>
            <input type="submit" id="submit" style="display: none">
        </form>
    </div>
    <br/>
    <div class="bottom">
        version:1.0
    </div>
</div>
</body>
</html>

</html>