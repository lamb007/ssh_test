<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <s:head theme="xhtml"/>
    <title>用户注册</title>
</head>
<body>
<s:form action="registerAction" method="post">
    <s:textfield name="user.username" label="请输入用户名"/>
    <s:password name="user.password" label="请输入密码"/>

    <s:submit value="注册"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
