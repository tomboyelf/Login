<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p>${msg }</p>
<%
session.removeAttribute("msg");
%>
<form action="Login.action" method="post">
	ユーザー名<input type="text" name="login" value="${login }" requierd><br>
	パスワード<input type="password" name="pass" requierd><br>
	<input type="submit" value="ログイン">
</form>
<p><a href="/Login/jsp/signup.jsp">会員登録が済んでいない人はこちら</a></p>
<p><a href="Admin.action">管理者画面</a></p>
