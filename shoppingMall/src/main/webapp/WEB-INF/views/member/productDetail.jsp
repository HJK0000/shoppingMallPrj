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
		<h1>Product Detail</h1>
		<hr>
	</header>
	<div class="row">
		<img src="/resources/images/${product.porigin_name }"
			alt="${product.pname }" />
		<p>${product.pname }</p>
		<span>${product.pprice }</span> <span><img class="star"
			src="/resources/images/star.png" /> <img class="star"
			src="/resources/images/star.png" /> <img class="star"
			src="/resources/images/star.png" /> <img class="star"
			src="/resources/images/star.png" /> <img class="star"
			src="/resources/images/star.png" /></span><span>({reviewlist.count})</span>F
	</div>
	<form action="/member/toMyBasket" method="post">
		<input type="hidden" name="pnum" value="${product.pnum}"> 
		<input type="text" value="1" class="prod-quantity"
			maxlength="${product.ptotalcount }" autocomplete="off">
		<button class="prod-quantity__plus" type="button">
		</button>
		<button class="prod-quantity__minus" type="button">
		</button>
		<input type="submit" value="장바구니 담기"></input>
	</form>
</body>
<script>
	// 버튼 누르면 수량 plus, minus 
	// product.ptotalcount 
</script>
</html>