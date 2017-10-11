<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>user_list</title>
  </head>
  
<body>
	<table width="60%" border="1" cellpadding="2" cellspacing="0" align="center">
		<tr>
			<th>玩家id</th>
			<th>唯一码</th>
			<th>游戏id</th>
			<th>玩家昵称</th>
			<th>玩家分数</th>
			<th>贪吃蛇长度</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.uid }</td>
				<td>${user.gid }</td>
				<td>${user.nick }</td>
				<td>${user.score }</td>
				<td>${user.length }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
