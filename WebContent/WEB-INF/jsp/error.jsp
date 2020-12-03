<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.button.signout" var="sign_out_button" />

</head>
<body>
	<form style="display: inline; float: right;" name="logoutForm" method="POST">
		<input type="hidden" name="logout" value="true"/>
		<input style="margin:5px 0 5px 0px;" type="submit" value="${sign_out_button}">
	</form>
	
	<h1>Acces Denied</h1>
	
</body>
</html>