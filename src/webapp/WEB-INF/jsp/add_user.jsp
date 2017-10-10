<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>add_user</title>
  </head>
  
<body>
	<form action="addUser.do"" method="post">
		<table width="40%" border="1" cellpadding="2" cellspacing="0" align="center">
			<tr>
				<td>唯一码:</td>
				<td><input type="text" name="uid"/></td>
			</tr>
			<tr>
				<td>游戏id:</td>
				<td><input type="text" name="gid"/></td>
			</tr>
			<tr>	
				<td>玩家昵称:</td>
				<td><input type="text" name="nick"/></td>
			</tr>
			<tr>	
				<td>玩家分数:</td>
				<td><input type="text" name="score"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
