<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>UserCreateConfirm画面</title>

	<%-- jQueryの使用 --%>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action',url);
			$('form').submit();
		}
	</script>

</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="UserCreateCompleteAction">
					<tr>
						<td><label>ログイン</label></td>
						<td><s:property value="#session.loginUserId"/></td>
					</tr>
					<tr>
						<td><label>ログインPASS；</label></td>
						<td><s:property value="#session.loginPassword"/></td>
					</tr>
					<tr>
						<td><label>ユーザー名：</label></td>
						<td><s:property value="#session.userName"/></td>
					</tr>
					<tr>
						<td><input type="button" value="戻る" onclick="submitAction('UserCreateAction')" /></td>
						<%-- theme="simple"テンプレート無効 --%>
						<td><s:submit value="完了" theme="simple"/></td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>