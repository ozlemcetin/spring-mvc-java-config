<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listing Organizations using the JSTL Sql Tag</title>
</head>
<body>

	<h1>Listing Organization using the JSTL Sql Tag</h1>

	<sql:query var="rs" dataSource="jdbc/springdb">
		SELECT * FROM organization
	</sql:query>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>id</th>
				<th>companyName</th>
				<th>yearOfIncorporation</th>
				<th>postalCode</th>
				<th>employeeCount</th>
				<th>slogan</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${rs.rows}">
				<tr>
					<td>${row.id}</td>
					<td>${row.company_name}</td>
					<td>${row.year_of_incorporation}</td>
					<td>${row.postal_code}</td>
					<td>${row.employee_count}</td>
					<td>${row.slogan}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>