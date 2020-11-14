<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listing Organizations using the Service</title>
</head>
<body>

	<h1>Listing Organization using the Service</h1>


	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>companyName</th>
				<th>yearOfIncorporation</th>
				<th>postalCode</th>
				<th>employeeCount</th>
				<th>slogan</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${orgList}">
				<tr>
					<td>${row.id}</td>
					<td>${row.companyName}</td>
					<td>${row.yearOfIncorporation}</td>
					<td>${row.postalCode}</td>
					<td>${row.employeeCount}</td>
					<td>${row.slogan}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>