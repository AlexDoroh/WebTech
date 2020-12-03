<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.button.signin" var="sign_in_button" />
<fmt:message bundle="${loc}" key="local.login" var="login" />
<fmt:message bundle="${loc}" key="local.password" var="password" />
</head>
<body>


	<span style="color: red;">${login_error}</span>
	<form name="loginForm" method="POST">
		${login}: <input style="display:block; width:170px;" type="text" name="login" value="" />
		${password}: <input style="display:block; width:170px;"  type="password" name="password" value="" />
		<input style="display:block; margin:5px 0 0 120px" type="submit" value="${sign_in_button}">
	</form>
</body>
</html>