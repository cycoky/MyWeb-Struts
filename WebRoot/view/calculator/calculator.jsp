<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript">
		function submitForm(actionName) {
			frm.action = 'to' + actionName + '.action';
			frm.submit();
		}
		// DMI方式调用，可能会有安全隐患，知道actionName和methodName即可随意调用
/* 		function submitForm(methodName) {
			frm.action = 'toArithmetic!' + methodName + '.action';
			frm.submit();
		} */
	</script>
	<style type="text/css">
		.calc{width : 20;} 
	</style>

  </head>
  
  <body>
  	<form name="frm" method="post">
  		<table>
  			<caption>四则运算计算器</caption>
  			<tr>
  				<td>操作数1：</td>
  				<td><input type="text" name="calc.operand1" value="${calc.operand1}"/></td>
  			</tr>
  			<tr>
  				<td>操作数2：</td>
  				<td><input type="text" name="calc.operand2" value="${calc.operand2}" /></td>
  			</tr>
  			<tr>
  				<td align="center">
  				<td>
<!-- 					<input class="calc" type="button" name="add" value="+" onclick="submitForm('toAdd')"/>
					<input class="calc" type="button" name="sub" value="-" onclick="submitForm('toSub')"/>
					<input class="calc" type="button" name="mul" value="*" onclick="submitForm('toMul')"/>
					<input class="calc" type="button" name="div" value="/" onclick="submitForm('toDiv')"/> -->
					<input class="calc" type="button" name="add" value="+" onclick="submitForm('add')"/>
					<input class="calc" type="button" name="sub" value="-" onclick="submitForm('sub')"/>
					<input class="calc" type="button" name="mul" value="*" onclick="submitForm('mul')"/>
					<input class="calc" type="button" name="div" value="/" onclick="submitForm('div')"/>
				</td>
  			</tr>
  			<tr>
  				<td>运算结果：</td>
  				<td><input type="text" name="calc.result" value="${calc.result}" /></td>
  			</tr>
  		</table>
  	
  	</form>
  </body>
</html>
