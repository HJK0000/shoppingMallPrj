<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>인덱스 페이지</title>
<style>
.star {
	width: 10px;
	height: 10px;
}
</style>
</head>
<body>
	<header>
		<h1>Login Form</h1>
		<hr>
	</header>
	<c:if test="${not empty errorMessage }">
		<script type="text/javascript">
			alert("${errorMessage}");
		</script>
	</c:if>

	<!-- 로그인 폼 -->

	<form action="/member/login" method="post">
		<table board="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="username"
					placeholder="아이디(이메일)을 입력하세요."></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="password"
					placeholder="비밀번호를 입력하세요."></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>


</body>
</html>