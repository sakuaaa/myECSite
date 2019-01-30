<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>ItemListDeleteConfirm画面</title>

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
			<p>ItemListDeleteConfirm</p>
		</div>
		<div>
			<h3>すべての商品を削除します。よろしいですか？</h3>
			<table>
				<s:form action="ItemListDeleteCompleteAction">
					<tr>
						<td><input type="button" value="キャンセル" onclick="submitAction('ItemListAction')" /></td>
						<%-- theme="simple"テンプレート無効 --%>
						<td><s:submit value="ＯＫ" theme="simple"/></td>
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