<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <s:form action="loginAction" method="post">
        <s:textfield name="user.username" label="请输入用户名"/>
        <s:password name="user.password" label="请输入密码"/>
        <s:submit value="登录"/>
    </s:form>

    <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
</body>
</html>