<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateuser.jsp' starting page</title>
    
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
     <center> <h1>修改教师个人信息面</h1><br/>
   	<form action="teacherAct!updateOwnTeacherInfo2.action" method="post">
   		密码：<input type="password" name="staff.staffPass" value="${teacher.staffInfo.staffPass}"/><br/>
   		手机号码：<input type="text" name="staff.staffPhone" value="${teacher.staffInfo.staffPhone}"/><br/>
   		QQ：<input type="text" name="staffInfo.staffQq" value="${teacher.staffInfo.staffQq}"/><br/>
   			<input type="submit" value="确定修改"/>
   </form>
   </center>
  </body>
</html>