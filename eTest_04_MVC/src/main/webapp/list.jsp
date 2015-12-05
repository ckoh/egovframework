<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="user.dao.UserDAO_JDBC"%>
<%@page import="user.dao.UserDAO"%>
<%@page import="user.service.UserServiceImpl"%>
<%@page import="user.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr> <th>userID</th> <th>UserName</th> <th>Email</th></tr>
  <c:forEach var="user" items="${users}">
      <tr>
         <td> ${user.userid} </td>
         <td> ${user.username} </td>
         <td> ${user.email} </td>
      </tr>
  </c:forEach> 
</table>
</body>
</html>






