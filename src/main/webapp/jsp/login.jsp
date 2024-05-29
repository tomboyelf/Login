<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<p>${loginMsg }</p>

<c:choose>
 <c:when test="${loginIf != null }">
	<p><a href="Logout.action">ログアウト</a></p>
 </c:when>
 <c:when test="${customer == null }">
	<form action="Login.action" method="post">
		ユーザー名<input type="text" name="login" value="${login }" required><br>
		パスワード<input type="password" name="pass" required><br>
		<input type="submit" value="ログイン">
	</form>
	<p><a href="/Login/jsp/signup.jsp">会員登録が済んでいない人はこちら</a></p>
 </c:when>
 <c:otherwise>
  <p>おしまい</p>
 </c:otherwise>
</c:choose>


<p><a href="Admin.action">管理者画面</a></p>
