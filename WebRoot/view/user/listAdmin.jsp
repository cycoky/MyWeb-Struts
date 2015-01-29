<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.coky.user.pojo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<table width='800' border ="1" align="center">
  		<caption>管理员列表</caption>
    	<tr bgcolor="lightblue">
    		<th>管理员编号</th>
    		<th>管理员名称</th>
    		<th>管理员密码</th>
    		<th>删除</th>
    		<th>修改密码</th>
    	</tr>
    	
    	<% 
    		List<Admin> adminList = (List<Admin>)request.getAttribute("adminList");
    		
    		for(int i = 0; i < adminList.size(); i++){
    			Admin a = adminList.get(i);
    			%>
    				<tr>
    					<td align="center"><%=a.getId() %></td>
    					<td align="center"><%=a.getName() %></td>
    					<td align="center"><%=a.getPwd() %></td>
    					<td align="center"><a href="del.action?id=<%= a.getId() %>" >删除</a></td>
    					<td align="center"><a href="<%=basePath%>view/user/editPwd.jsp?id=<%=a.getId()%>&name=<%=a.getName() %>" >修改密码</a></td>
    				</tr>
    			<%
    		}
    		
    	 %>
    	
    	</table>
    	<br>
    	<center><a href="AddAdmin.html">添加管理员</a></center>
  </body>
</html>
