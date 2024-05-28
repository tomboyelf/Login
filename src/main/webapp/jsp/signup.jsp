<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.html" %>

<p>${msg }</p>
<form action="Signup.action" method="post">
	ユーザー名<input type="text" name="login" required><br>
	パスワード<input type="password" name="pass" required><br>
	<input type="submit" value="登録">
</form>
<p><a href="/Login/jsp/login.jsp">ログイン画面へ戻る</a></p>
<%@include file="/footer.html" %>