<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Viewer</title>
</head>
<body>
	<header>
		<h1>Expense Details</h1>
		<a href="/">Go back</a>
	</header>
	<div class="container">
		<p>Expense Name: ${ expense.name }</p>
		<p>Expense Description: ${ expense.description }</p>
		<p>Vendor: ${ expense.vendor }</p>
		<p>Amount Spent: ${ expense.amount }</p>
	</div>

</body>
</html>