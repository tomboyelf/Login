<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.html"%>

<form action="Login.action" method="post">
<p>ユーザー名<input type="text" name="name"></p>
<p>パスワード<input type="password" name="pass"></p>
<input type="submit" value="ログイン">
</form>


<%@ include file="../footer.html"%>
