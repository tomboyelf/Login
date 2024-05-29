<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../login.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="list" items="${list}">
	<img src="../image/${list.id }.png">
    <p>商品番号:${list.id}/商品名:${list.productName}/値段:${list.price}<br>
  <%--  <form action="Deleteacc.action" method="post">
		<input type="hidden" name="delete_button" value="${list.id}">
		<input type="submit" value="削除">
	</form> --%>
</c:forEach>
<%@include file="../../footer.html" %>
