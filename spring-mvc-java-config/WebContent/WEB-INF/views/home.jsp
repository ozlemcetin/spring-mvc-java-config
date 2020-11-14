<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Organization Home Page</title>
</head>
<body>

	<h1>Organization Home Page</h1>

	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<ul>
		<li><a href="${contextPath}/jstlsql">listOrganizationUsingSql</a>
		</li>
		<li><a href="${contextPath}/service">listOrganizationUsingService</a>
		</li>
	</ul>
</body>
</html>