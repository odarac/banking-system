<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">

	<title>Make Transaction</title>
	
	<style>
		.custom-form::after {
		  content: "";
		  clear: both;
		  display: table;
		}
	</style>
	
	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	
</head>

<body>
	<!-- Transaction form can be used to make a transfer or payment -->
	<div class="container mt-5">
	
		<h2 class="mb-4 text-center">Make Transaction</h2><br>
		
		<form method="post" action="makeTransaction" class="custom-form">
		
			<input type="hidden" name="sessionID" value="2">
	
			<select name="type" class="form-control custom-input"> 
				<option value="transfer">Transfer</option>
				<option value="payment">Payment</option>
			</select>
			
			<input type="submit" value="Choose Transaction Type" name="submit" class="btn btn-primary custom-btn" style="float: right;">

			
		</form><br>
	
		<h2 class="mb-4 text-center">Beneficiaries</h2>
			
		<div class="custom-form">	
			<p>Beneficiaries added will only be available for transactions through Transfers</p>	
			
			<a href="AddBeneficiary.jsp">
				<input type="button" value="Add Beneficiary" name="addBeneficiary"  class="btn btn-primary custom-btn">
			</a>
			
			<form method="post" action="viewBeneficiary">
			
				<input type="hidden" name="sessionID" value="2">
				
				<input type="submit" value="View Beneficiary Details" name="viewUpdateBeneficiary" class="btn btn-primary custom-btn">
				
			</form>
		</div><br>
		
		<h2 class="mb-4 text-center">Past Transactions</h2>
			
		<div class="custom-form">
			<form method="post" action="viewTransaction">
			
				<input type="hidden" name="sessionID" value="2">
				
				<input type="submit" value="View Past Transactions" name="pastTrasactions" class="btn btn-primary custom-btn">
				
			</form>
		</div>
	
	</div>
	
	<br><br><br>
	

</body>
</html>