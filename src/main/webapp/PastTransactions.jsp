<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Past Transactions</title>

	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body>

	<div class="container mt-5">
	
	<h2 class="mb-4 text-center">Past Transaction Details</h2>
	
		<table class="table table-striped">
			<tr>
				<th>Transaction ID</th>
				<th>Sender Account</th>
				<th>Beneficiary ID</th>
				<th>Amount</th>
			</tr>
			
			<c:forEach var="transac" items="${pastTransaction}">
	
			<tr>
				<td>${transac.transactionID}</td>
				<td>${transac.senderAcc}</td>
				<td>${transac.beneficiaryID}</td>
				<td>${transac.amount}</td>				
			</tr>
		
			</c:forEach>
			
		</table>
	
	</div>

</body>
</html>