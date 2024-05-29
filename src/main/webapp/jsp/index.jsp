<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login.jsp" %>
	<form action="Product.action" method="post">
		<input type="hidden" name="productA" value="A">
		<input type="submit" value="商品群Aのページへ">
	</form>
<%@include file="../footer.html" %>
