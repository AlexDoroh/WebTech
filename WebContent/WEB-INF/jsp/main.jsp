<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.button.signout" var="sign_out_button" />
<fmt:message bundle="${loc}" key="local.firstname" var="first_name" />
<fmt:message bundle="${loc}" key="local.lastname" var="last_name" />
<fmt:message bundle="${loc}" key="local.username" var="username" />

</head>
<body>
	
	<span>${username}: ${login}</span>
	

	<form style="display: inline; float: right;" name="logoutForm" method="POST">
		<input type="hidden" name="logout" value="true"/>
		<input style="margin:5px 0 5px 0px;" type="submit" value="${sign_out_button}">
	</form>
	
	<form style="display: inline; margin:5px 5px 5px 0; float: right;" name="localeForm"   method="POST">
		<select name="local">
            <option selected value="en" >EN</option>
        	<option value="ru" >RU</option>
        </select>
		<input  type="submit" value="OK">
	</form>
	
	
	
	<% List<User> users = (List<User>)request.getAttribute("users"); %>
	
	<table border="1" style="width: 50%" height="50%">
	  <thead>
	   <tr>
	    <th>ID</th>
	    <th>${first_name}</th>
	    <th>${last_name}</th>
	   </tr>
	  </thead>
	  <tbody>
	   <!--   for (Todo todo: todos) {  -->
	   <% for(User user : users){ %>
	   <tr>
	    <td><%=user.getId_User()%></td>
	    <td><%=user.getRole()%></td>
	 
	   </tr>
	   <%} %>
	  </tbody>
	
	 </table>

<!-- 	<a href="main">click here</a> -->
</body>
</html>