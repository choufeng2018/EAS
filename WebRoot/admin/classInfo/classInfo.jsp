<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classInfoForGrade.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    <s:debug></s:debug>
    <table border="1">
    <thead>
    <tr>
    <td>年级名</td><td>班级</td><td>学生人数</td><td>修改</td><td>删除</td>
    </tr>
    </thead>
    <c:forEach items="${request.class }" var="i">
    <tr>
    <td>
    	${i.gradeInfo.gradeName }
    	<c:if test="${empty i.gradeInfo}">
    	不属于任何年级
    	</c:if>
    </td>
    <td>${i.className }</td>
    <td>${fn:length(i.studentInfos) }</td>
    <td><a href="<%=basePath%>class!updateClass.action?classId=${i.classId }">修改</a></td>
    <td><a href="<%=basePath%>class!deleteClass.action?classId=${i.classId }">删除班级</a></td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>