<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.html" %>

<p>別のページ</p>
<p>ユーザー名「${customer.login }」はそのまま</p>
<p><a href="/Login/jsp/login-out.jsp">ログイン成功画面へ</a></p>
<p><a href="/Login/logout">ログアウト</a></p>

<%@include file="/footer.html" %>