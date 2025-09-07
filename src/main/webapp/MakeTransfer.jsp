<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Transfer</title>
	
	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<div class="container mt-5">
	
		<h2 class="mb-4 text-center">Transfer</h2><br>
		
		<form method="post" action="submitTransaction" class="custom-form">
		
			<input type="hidden" name="sessionID" value="2">
	
			<label for="senderAcc">Sender Account</label><br>
			<select name="senderAcc" class="form-control custom-input" required>
            	<c:forEach items="${accList}" var="acc">
                	<option value="${acc.accno}">${acc.accno}</option>
            	</c:forEach>
        	</select><br><br>
			
			<label for="beneficiary">Beneficiary</label><br>
			
			<select name="beneficiary" class="form-control custom-input" required>
            	<c:forEach items="${beneList}" var="bene">
                	<option value="${bene.beneficiaryID}">${bene.beneficiaryName} - ${bene.accNo}</option>
            	</c:forEach>
        	</select><br><br>
        	
        	
			<label for="amount">Amount</label><br>
			<input type="text" name="amount" class="form-control custom-input" required><br><br><br>
			
			<input type="submit" value="Submit" name="MakeTransaction" class="btn btn-primary custom-btn">
			
		</form>
		
	
	</div>
	

</body>
</html>