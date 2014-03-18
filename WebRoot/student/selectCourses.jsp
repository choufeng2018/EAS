<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectCourses.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="css/body.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
  </head>
  
  <body>
	<center> <h1>在线选课界面</h1><br/>
		<form action="student!addRegisterInfo.action" method="post">  
    	<table border="1">
    		<tr>
    			<td>课程编号</td>
    			<td>专业名称</td>
    			<td>课程名称</td>
    			<td>开课时间</td>
    			<td>课程结束时间</td>
    			<td>课程价格</td>
    			<td>课程介绍</td>
    			<td>是否选择</td>
    		</tr>  
    		<c:forEach items="${allCourseInfo}" var="courses" varStatus="s">
    			<tr> 
    				<td>${courses.courseId}</td>
    				<td>${courses.majorInfo.majorName}</td>
    				<td>${courses.courseName}</td>
    				<td>${courses.courseStart}</td>
    				<td>${courses.courseEnd}</td>
    				<td>${courses.coursePrice}</td>
    				<td>${courses.courseDesc}</td>
	 				<c:choose>
    					<c:when test="${courses.courseId == courseInfo[s.count-1].courseId}">
    						<td>已选</td>
    					</c:when>
    					<c:otherwise>
    						<td><input type="checkbox" name="selectCourseId" value="${courses.courseId}"></td>
    					</c:otherwise>  
   					</c:choose>
    			</tr>
    		</c:forEach> 
    	</table>
    	<input type="hidden" name="studentInfo.studentNo" value="${session.studentNo}"/><br/>
    	<input type="submit" value="确认选课"></form> 
	</center>
  </body>
</html>