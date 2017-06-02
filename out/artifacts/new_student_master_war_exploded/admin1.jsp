<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <title>admin1</title>
</head>
<body>
        <h1>i am admin1</h1>
    <form action="${pageContext.request.contextPath}/logout.action" method="post" >

     <h1 > 欢迎用户:${principal.username}</h1>

        <shiro:hasPermission name="user:update">
         <input type="submit" value="logout">
            <a href="${pageContext.request.contextPath}/index/index.action" >到目录</a>
        </shiro:hasPermission>
        <!-若是没有权限，则不显示-->
        <shiro:hasPermission name="user:update">
        <a href="${pageContext.request.contextPath }/admin123.jsp">dao123</a>

        </shiro:hasPermission>
    </form>
</body>
</html>
