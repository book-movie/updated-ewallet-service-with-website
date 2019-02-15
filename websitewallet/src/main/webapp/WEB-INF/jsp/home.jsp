<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="details" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Welcome To Book My Movie...!</h1>


<a href ="updateBalance">Add Money</a>

<a href ="statements">Get Statements</a>


<table>

	<tr>
		<th>transaction_id </th>	
		<th>amount </th>
		<th>transaction_date </th>

		<th>transaction_details </th>
		<th>transaction_type</th>
	</tr>
	
	<details:forEach var="statement" items="${statements}">
	<tr>
		<td>${statement.transactionId}</td>
		<td>${statement.amount}</td>
		<td>${statement.dateTime}</td>	
		<td>${statement.transactionRemarks}</td>
		<td>${statement.transactionType}</td>
	</tr>
	</details:forEach>
	
</table>
</body>
</html>