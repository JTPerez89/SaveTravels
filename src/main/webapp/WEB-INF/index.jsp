<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${ expenses }">
					<tr>
						<td>
						<a href="/expenses/${ expense.id }"><c:out value="${ expense.name }" /></a>
						</td>
						<td><c:out value="${ expense.vendor }" /></td>
						<td><c:out value="${ expense.amount }" /></td>
						<td class="d-flex">
							<a href="/update/${expense.id}">Edit</a>
							<form action="/delete/${expense.id}" method="post" class="ms-4">
								<input type="hidden" name="_method" value="delete"> 
								<input type="submit" value="Delete">
							</form>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Add an expense:</h2>
		<div class="m-4 ps-4">
			<form:form action="/new" method="POST" modelAttribute="expense">
				<p>
					<form:label path="name">Expense name:</form:label>
					<form:input path="name" />
					<br />
					<form:errors path="name" class="text-danger" />
				</p>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:input path="vendor" />
					<br />
					<form:errors path="vendor" class="text-danger" />
				</p>
				<p>
					<form:label path="amount">Amount:</form:label>
					<form:input type="number" path="amount" />
					<br />
					<form:errors path="amount" class="text-danger" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:textarea path="description" />
					<br />
					<form:errors path="description" class="text-danger" />
				</p>
				<input type="submit" value="Submit" class="btn bg-dark text-light" />
			</form:form>
		</div>
	</div>

</body>
</html>