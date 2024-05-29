<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="list" items="${allList}">
    ${list.id}:${list.login}:${list.password}<br>
    <form action="Deleteacc.action" method="post">
		<input type="hidden" name="delete_button" value="${list.id}">
		<input type="submit" value="削除">
	</form>
</c:forEach>
<p>${msg }</p>
<p><a href="Admin.action">管理者画面</a></p>
<p><a href="/Login/jsp/index.jsp">ホームへ戻る</a></p>

<%@include file="/footer.html" %>