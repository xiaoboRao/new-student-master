<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/15
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin123</title>
</head>
<body>
<h1>i am admin123</h1>
<form action="${pageContext.request.contextPath}/logout.action" method="post" >

    <input type="submit" value="logout">
    <a href="${pageContext.request.contextPath}/index/back.action"> 到back.action</a>
</form>
</body>
</html>
