<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>Admin画面</title>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>admin</p>
		</div>
		<div id="text-center">
			<div id="box1">
				<h3>商品</h3>
				<s:form action="ItemCreateAction">
					<s:submit cssClass="submit" value="新規登録"/>
				</s:form>
				<s:form action="ItemListAction">
					<s:submit cssClass="submit" value="一覧"/>
				</s:form>
			</div>
			<div id="box2">
				<h3>ユーザー</h3>
				<s:form action="UserCreateAction">
					<s:submit cssClass="submit" value="新規登録"/>
				</s:form>
				<s:form action="UserListAction">
					<s:submit cssClass="submit" value="一覧"/>
				</s:form>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>