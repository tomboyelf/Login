<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.html" %>

<p>ログイン成功画面</p>
<p>ようこそ、${customer.login }さん！</p>
<p><a href="/Login/jsp/another.jsp">別のページへ</a></p>
<p><a href="Logout.action">ログアウト</a></p>

<%@include file="/footer.html" %>