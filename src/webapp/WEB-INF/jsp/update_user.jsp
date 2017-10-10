<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>update_user</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/json.js"></script>
    <script type="text/javascript">
    	function save(){
    		$.ajax({
    			type:"PUT",
    			url:"/snake_api/user/update",
    			data:JSON.stringify($("#myform").serializeObject()),
    			dataType:"json",
    			contentType:"application/json",
    			success:function(data){
    				location.href="/snake_api/user/find";
    			}
    		});
    	}
    </script>
  </head>
  
<body>
	<form action="updateUser.do"" method="post" id="myform">
		<table width="40%" border="1" cellpadding="2" cellspacing="0" align="center">
			<tr>	
				<td>玩家昵称:</td>
				<td><input type="text" name="nick" value="${user.nick}"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"
					onclick="save();"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
