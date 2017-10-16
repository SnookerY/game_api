<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>user_list</title>
  </head>
  
<body>
	<table width="60%" border="1" cellpadding="2" cellspacing="0" align="center">
		<tr>
			<th>游戏id</th>
			<th>玩家昵称</th>
			<th>玩家分数</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.gid }</td>
				<td>${user.nick }</td>
				<td>${user.score }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
