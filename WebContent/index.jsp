<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 </title>
</head>
<body>
<c:if test="${!empty authUser}">
	${authUser.name}님, 안녕하세요.
	<br>
	<a href="logout.do">[로그아웃하기]</a><br>
	<a href="changePwd.do">[암호변경하기]</a><br>
	<a href="article/write.do">[게시글쓰기]</a>
	<a href="article/list.do">[게시글목록보기]</a>
</c:if>
<c:if test="${empty authUser}">
	<a href="join.do">[회원가입하기]</a>
	<a href="login.do">[로그인하기]</a>
</c:if>
<br/>
</body>
</html>