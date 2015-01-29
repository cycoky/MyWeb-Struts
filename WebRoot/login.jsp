<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = "<a href='welcome.html'>欢迎界面</a>";
pageContext.setAttribute("su", url);
pageContext.setAttribute("now", new Date());

List<String> bookList = new ArrayList<String>(5);
bookList.add("Spring 3.0技术宝典");
bookList.add("Struts2 权威指南");
bookList.add("Jaavascript 高级进阶");
bookList.add("JSP 从入门到精通");
bookList.add("Ajax 实战");
pageContext.setAttribute("bookList", bookList);

List<String> xj = new ArrayList<String>();
xj.add("乌鲁木齐");
xj.add("阿克苏");
xj.add("和田");
xj.add("石河子");

List<String> gs = new ArrayList<String>();
gs.add("兰州");
gs.add("天水");
gs.add("舟曲");

Map<String, List<String>> pc = new HashMap<String, List<String>>();
pc.put("新疆省", xj);
pc.put("甘肃省", gs);
pageContext.setAttribute("pc", pc);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
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
    <form action="login.action" method="post">
    	<table width='397' height="169" border ="0" align="center">
    		<tr>
    			<td colspan="2" align="center">管理员登陆</td>
    		</tr>
    		<tr>
    			<td width="163">登陆名称：</td>
    			<td width="218"><input name="name" type="text" class="txt"></td>
    		</tr>
    		<tr>
    			<td width="163">登陆密码：</td>
    			<td width="218"><input name="pwd" type="password" class="txt"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交"></td>
    		</tr>
    	</table>  
    </form>
  	<!-- 利用action标签，将执行结果页面嵌入到当前页面中 -->
  	
  	<h1>1.非UI标签</h1>
  	<h2>①数据访问标签</h2>
  	
  	<h3>一、action标签</h3>
  		<span style="font-size:30px;">
  			<s:action name="welcome" executeResult="true" namespace="/admin">
  			</s:action>
  		</span>
  	<h3>二、property标签</h3>
	  	<s:property value="#attr.su" /><br>
	  	<s:property value="#attr.su" escape="false"/><br>
	  	<s:property value="#attr.uid" default="找不到uid属性" /><br>
	  	<s:property/>
    
    <h3>三、include标签</h3>
    	<s:include value="innerPage.html"></s:include>
    <h3>四、url标签</h3>
	    <s:url action="showPerson">
	    	<s:param name="name" value="'Jack'"></s:param>
	    </s:url><br>
	    <s:url var="u" value="http://localhost:8888/Struts/welcome.html">
	    	<s:param name="name" value="'Rose'" />
	    </s:url>
    
    <h4>1.与HTML超链接标签结合</h4>
	    <a href="<s:url value="http://localhost:8888/Struts/welcome.html">
	    	<s:param name="name" value="'Rose'" />
	    </s:url>">链接</a>
    <h4>2.与struts2超链接标签结合</h4>
    	<s:a href="%{u}">测试</s:a>
    
    <h3>五、date标签</h3>
    	<s:date name="#attr.now" format="yyyy/MM/dd" />
    
    <h2>②逻辑控制标签</h2>
    
    <h3>一、if/elseif/else</h3>
	    <s:set name="score" value="90"></s:set>
	    <s:if test="#score > 90">成绩优秀</s:if>
	    <s:elseif test="#score > 80">成绩良好</s:elseif>
	    <s:else>成绩合格</s:else>
	    
	<h3>二、iterator标签</h3>
		<s:iterator value="#attr.bookList" id="bookName">
			<li><s:property value="bookName" /></li>
		</s:iterator>
		<table border="1" width="200px">
			<s:iterator value="#attr.bookList" id="bookName" status="st">
				<tr <s:if test="#st.odd">style="background-color:skyblue"</s:if>>
					<td><s:property value="#st.index" /></td>
					<td><s:property value="bookName" /></td>
				</tr>
			</s:iterator>
		</table>
	
		
	<h1>2.UI标签</h1>

	<h2>①表单标签</h2>
		<h3>一、&lt;s:form&gt; 标签</h3>
		&lt;s:form action="welcome.action" namespace="/admin"&gt;&lt;/s:form&gt;
		<h3>二、文本类标签</h3>
		&lt;s:textfield&gt;<br>
		&lt;s:password&gt;<br>
		&lt;s:textarea&gt;<br>
		&lt;s:submit&gt;<br>
		&lt;s:reset&gt;<br>
		
		示例：<br>
		<s:form action="login.action" namespace="/login">
			<s:textfield name="name" label="登陆名称"></s:textfield>
			<s:password name="pwd" label="登录密码"></s:password>
			<s:textarea name="info" label="个人简介" cols="28" rows="10"></s:textarea>
			<s:submit value="提交"></s:submit><s:reset value="重置"></s:reset>
		</s:form>
		
		<h3>三、checkboxlist</h3>
			<s:checkboxlist list="{'Java', 'Javascript', 'Spring', 'Struts'}" name="skills" label="熟悉技术"></s:checkboxlist><br>
			<s:checkboxlist list="#{'java':'JAVA', '.net': '.NET', 'srping' : 'Spring', 'struts' : 'Struts'}" name="skillsarea" label="您所关注的领域"></s:checkboxlist>
		
		<h3>四、radio</h3>
			<s:radio list="{'Java', 'Javascript', 'Spring', 'Struts'}" name="skills" label="熟悉技术"></s:radio><br>
			<s:radio value="java" list="#{'java':'JAVA', '.net': '.NET', 'srping' : 'Spring', 'struts' : 'Struts'}" name="skillsarea" label="您所关注的领域"></s:radio>
		
		<h3>五、select</h3>
			<s:select list="{'XX语言入门', 'XX语言进阶', '精通XX语言', 'XX之禅', '劲椎病的康复治疗指南'}" name="skills" label="程序员之路"></s:select><br>
			<s:select list="#{'java':'JAVA语言入门', 'java1': 'JAVA语言进阶', 'java2' : '精通JAVA', 'java3' : 'JAVA之禅', 'java4' : '劲椎病的康复治疗指南'}" name="skillsarea" label="图书列表"></s:select>
		
		<h3>六、doubleselect</h3>
		<s:form action="welcome.action" namespace="/admin">
			<s:doubleselect doubleList="#attr.pc[top]" list="#attr.pc.keySet()" name="province" doubleName="city" label="省市级联"></s:doubleselect>
		</s:form>
		<h3>七、token</h3>
		
	<h2>②非表单标签</h2>
  </body>
</html>
