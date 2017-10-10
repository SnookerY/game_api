<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>user_list</title>
  	<script type="text/javascript" src="../js/jquery.js"></script>
  	<!-- <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script> -->
  </head>
  
<body>
	<div align="center">
		<input type="button" value="新增" onclick="locaton.href='toAdd'"/>
	</div>	
	<table width="60%" border="1" cellpadding="2" cellspacing="0" align="center">
		<tr>
			<th>唯一码</th>
			<th>游戏id</th>
			<th>玩家昵称</th>
			<th>玩家分数</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.uid }</td>
				<td>${user.gid }</td>
				<td>${user.nick }</td>
				<td>${user.score }</td>
				<td>
					<input type="button" value="修改" 
		onclick="locaton.href='toUpdate/${user.gid}'"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
