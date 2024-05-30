<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<h1>Regist Form</h1>
	<hr>

	<form action="regist" method="post">
		<table board="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="username"
					placeholder="아이디(이메일)을 입력하세요."></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="password1"
					placeholder="비밀번호를 입력하세요."></td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="password" name="password2"
					placeholder="비밀번호를 한번 더 입력하세요."></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" placeholder="이름을 입력하세요."></td>
			</tr>
			<tr>
				<th>핸드폰 번호</th>
				<td><input type="text" name="tel" placeholder="핸드폰 번호를 입력하세요."></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr" placeholder="주소를 입력하세요."></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="role"
					value="ROLE_MEMBER"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>