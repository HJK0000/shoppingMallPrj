<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>헤더</title>
<style>
</style>
</head>
<body>
	<header>
		<c:if test="${id == null}">
			<h1>메인 페이지</h1>
			<button>
				<a href="/member/registForm">회원가입</a>
			</button>
			<button>
				<a href="/member/loginForm">로그인</a>
			</button>
		</c:if>
		<c:if test="${id != null && role == 'ROLE_MEMBER'}">
			<h1>일반 회원 메인</h1>
			<a href="#">내 주문목록</a>
			<a href="#">장바구니 가기</a>
			<button>
				<a href="/member/logout">로그아웃</a>
			</button>
		</c:if>
		<c:if test="${id != null && role == 'ROLE_ADMIN'}">
			<h1>관리자 메인</h1>
			<a href="/admin/productRegistForm">상품 등록</a>
			<a href="#">재고 관리</a>
			<button>
				<a href="/admin/logout">로그아웃</a>
			</button>
		</c:if>
		<hr>
	</header>
</body>
</html>