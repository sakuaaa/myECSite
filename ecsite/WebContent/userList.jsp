<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
	<title>ItemList画面</title>
	<script>
		function checkValue(check) {
			var checkList = document.getElementsByClassName("checkList");
			var checkFlag = 0;
			for (var i = 0; i < checkList.length; i++) {
				if (checkFlag == 0) {
					if (checkList[i].checked) {
						checkFlag = 1;
						break;
					}
				}
			}
		}
	</script>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test="#session.userList == null || #session.userList.isEmpty()">
				<h3>ユーザー情報はありません。</h3>
			</s:if>
			<s:else>
				<h3>ユーザー情報は以下になります。</h3>
				<s:form action="UserListDeleteConfirmAction">
					<table border="1">
						<tr>
							<td>#</td>
							<td>ID</td>
							<td>ユーザーID</td>
							<td>パスワード</td>
							<td>ユーザー名</td>
							<td>登録日</td>
						</tr>
						<s:iterator value="#session.userList">
							<tr>
								<td><s:checkbox name="checkList" class="checkList" value="checked" fieldValue="%{id}" theme="simple"/></td>
								<td><s:property value="id"/></td>
								<td><s:property value="loginId"/></td>
								<td><s:property value="loginPass"/></td>
								<td><s:property value="userName"/></td>
								<td><s:property value="insertDate"/></td>
							</tr>
						</s:iterator>
					</table>
					<input type="submit" value="削除" />
				</s:form>
			</s:else>
			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>