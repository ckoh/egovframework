<%@page import="user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="user.dao.UserDAO_JDBC"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<%-- 
	<%
		// jsp-jdbc 기반 // 

		// dao 접근 
		UserDAO dao = new UserDAO_JDBC();

		// 서비스 
		UserService service = new UserServiceImpl(dao);

		// 결과
		List<UserVO> list = service.getUserList();

		// request
		request.setAttribute("users", list);
	%> --%>
	<table border="1">
		<tr>
			<th>유저아이디</th>
			<th>네임</th>
			<th>이메일</th>
		</tr>
		<c:forEach var="user" items="${users }" varStatus="status">
			<tr>
				<td>${user.userid }</td>
				<td>${user.username }</td>
				<td>${user.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>