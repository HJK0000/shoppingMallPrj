<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>장바구니 페이지</title>
<style>
</style>
</head>
<body>
	<h1>장바구니</h1>
	<hr>

	<table border="1">
		<td><checkbox></checkbox></td>
		<td>${product.porigin_name }</td>
		<td>${product.pname }</td>
		<td>${product.pprice }</td>
		<td>${product.pdelievery }</td>
		<td>${basket.basket_count }</td>
		<td>${basket.basket_price }</td>
	</table>


</body>
</html>