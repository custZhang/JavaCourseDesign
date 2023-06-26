<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/"
            ;
    pageContext.setAttribute("basePath",basePath);
%>
<%--    解除el表达式的禁用--%>
<%@ page isELIgnored="false" %>
<%--<%= basePath %>--%>
<base href= "<%=basePath%>">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
