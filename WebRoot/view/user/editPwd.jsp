<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
  	String id = (String)request.getParameter("id");
  	String name = (String)request.getParameter("name");
  	String errorMsg = (String)request.getAttribute("errorMsg");
  	if(errorMsg == null){
  		errorMsg = "";
  	}
   %>
  
  	<form action="editPwd.action" method="post">
  		<input type="hidden" name="id" value=<%=id %> />
  		<input type="hidden" name="name" value=<%=name %> />
    	<table width='397' height="169" border ="0" align="center">
    		<tr>
    			<td colspan="2" align="center">修改密码</td>
    		</tr>
    		<tr>
    			<td width="163">登陆名称：</td>
    			<td width="218"><%=name %></td>
    		</tr>
    		<tr>
    			<td width="163">原始密码：</td>
    			<td width="218"><input name="pwdOriginal" type="password" class="txt"></td>
    		</tr>
    		<tr>
    			<td width="163">新设密码：</td>
    			<td width="218"><input name="pwdNew" type="password" class="txt"></td>
    		</tr>
    		<tr>
    			<td width="163">确认密码：</td>
    			<td width="218"><input name="pwdNew1" type="password" class="txt"></td>
    		</tr>
    		<tr>
    			<td colspan="2"><span style="color :red;"><%=errorMsg %></span></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交"></td>
    		</tr>
    	</table>  
    </form>
  </body>
</html>
