<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register user</title>
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
  	<!-- 以下执行了默认方法execute(),也可以省略.action -->
    <form method="post" action="userInforAction.action">
    	用户总数： <s:property value="countuser"/><br>
    	用户名：<input type="text" name="username"><br>
    	密码：<input type="password" name="userpws"><br>
    	确认密码：<input type="password" name="userpws2"><br>
    	
    	<input type="submit" value="提交"/><br>
    	<s:debug></s:debug><br>
    </form>
  </body>
</html>
