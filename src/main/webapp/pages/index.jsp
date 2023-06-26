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
            // 给删除的 a 标签绑定单击事件，用于删除的确认提示操作
            $("a.delete-btn").click(function () {
                // 在事件的 function 函数中，有一个 this 对象。这个 this 对象，是当前正在响应事件的 dom 对象。
                /**
                 * confirm 是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消。
                 * 返回 true 表示点击了，确认，返回 false 表示点击取消。
                 */
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
                // return false// 阻止元素的默认行为===不提交请求
            });

            $("a.delete-autoLogin").click(function () {
                return confirm("删除后，下次使用时将不会自动登录，确定删除吗?")
            })

            $("a.inbox-btn").click(function () {
                return alert("功能开发中，敬请期待");
            })

            $("a.rename-btn").click(function () {
                const fileNameElem = $(this).parent().parent().find("td:first");//获取fname元素
                var oldName = fileNameElem.text();//先保存旧值
                fileNameElem.html("<input type='text' value='" + oldName + "'/>");//将fname位置更换为输入框

                const input = fileNameElem.find('input');//获取输入框
                input.focus();//将光标聚集在文本输入框上
                input[0].selectionStart = 0;
                input[0].selectionEnd = oldName.lastIndexOf(".");

                //用户按回车，调用失去焦点事件
                input.on("keydown", function(event) {
                    if (event.which === 13) { // 如果按下的是回车键
                        input.blur(); // 手动触发 "blur" 事件
                    }
                });

                // 当用户完成输入后，向file提交新的文件名
                input.blur(function () {
                    const newName = input.val().trim();
                    if (newName === '' || newName === oldName) {
                        // 如果文件名为空或没有修改，则不做任何更改
                        fileNameElem.html(oldName);
                        return;
                    }
                    // 发送重命名请求
                    window.location.href = "file/rename?oldName=" + oldName + "&newName=" + newName;
                });
            });
        })

        function submitForm() {
            const form = document.getElementById('upload-form');
            form.submit();
        }

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
            /*background-image: url("file_icon.png");*/
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
        }

        #left-bar #inbox-btn {
            /*background-image: url("inbox_icon.png");*/
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
            cursor: pointer;
        }

        #left-bar #note-btn {
            /*background-image: url("inbox_icon.png");*/
            background-repeat: no-repeat;
            background-position: left 5px center;
            background-size: 20px;
            padding-left: 30px;
        }

        #left-bar #logout-btn {
            /*background-image: url("logout_icon.png");*/
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
        }

        .btn:hover {
            background-color: #0065FF;
        }

        #new-btn {
            float: right;
            padding: 10px 30px;
        }

        #newBtn {
            float: right;
            padding: 10px 30px;
            cursor: pointer;
        }

        a.download-btn, a.delete-btn, a.rename-btn {
            display: inline-block;
            color: #FFF;
            padding: 5px 10px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s;
            cursor: pointer;
        }

        a.download-btn {

            background-color: cornflowerblue;
        }

        a.download-btn:hover {
            background-color: #007AFF;
        }

        a.delete-btn {

            background-color: lightcoral;
        }

        a.delete-btn:hover {
            background-color: #FF3B30;
        }

        a.rename-btn {
            background-color: #FF9500;

        }

        a.rename-btn:hover {
            background-color: #E68100;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #EEE;
        }

        th {
            background-color: #EEE;
            font-weight: normal;
        }

        td:last-child {
            text-align: center;
        }

        #notice {
            background-color: #EEE;
            padding: 20px;
            border-radius: 5px;
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
            <a class="btn" id="newBtn" href="pages/user/login.jsp">上传</a>
        </c:if>
        <c:if test="${not empty sessionScope.loginUser}">
            <form action="file/upload" method="post" enctype="multipart/form-data" id="upload-form">
                <label for="new-btn" class="btn" id="newBtn">上传</label>
                <input type="file" id="new-btn" name="file" onchange="submitForm()" style="display: none;">
            </form>
        </c:if>

        <p>已用空间：${sessionScope.loginUser == null ? "0.0" : sessionScope.loginUser.currentSize}MB/
            ${sessionScope.loginUser == null ? "114.51" : sessionScope.loginUser.maxSize}MB</p>
        <table>
            <tr>
                <th>文件名</th>
                <th>大小</th>
                <th>日期</th>
                <th>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;操作</th>
            </tr>
            <c:forEach items="${sessionScope.files}" var="file">
                <tr>
                    <td>${file.fname}</td>
                    <td>${file.fsize}MB</td>
                    <td>${file.updatetime}</td>
                    <td>
                        <a href="file/download?downloadFName=${file.fname}" class="download-btn">下载</a>
                        <a href="file/delete?deleteFName=${file.fname}&deleteFSize=${file.fsize}"
                           class="delete-btn">删除</a>
                        <a class="rename-btn">重命名</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <div id="notice"><h3>公告</h3>
            <p>
                欢迎使用。
                <br/>
                <br/>
                <a href="static/img/tutorial.jpg" target="_blank">手机端上传文件教程</a>
                <br/>
                <a class="delete-autoLogin" href="user/deleteAutoLogin">删除已保存的7天免登录信息</a>
                <br/>
                <br/>
                ${sessionScope.notice}
            </p>
        </div>
    </div>
    <div class="bottom">
        <p>version:1.0</p>
    </div>
</div>
</body>
</html>

</html>