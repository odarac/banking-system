<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<meta charset="UTF-8">
	<title>Manage Beneficiaries</title>

	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<div class="container mt-5">

		<h2 class="mb-4 text-center">Add Beneficiary</h2><br>
		
		<form method="post" action="addBeneficiary" class="custom-form">
		
			<input type="hidden" name="sessionID" value="2">
	
			<label for="beneAcc">Beneficiary Account: </label><br>
			<input type="text" class="form-control custom-input" name="beneAcc" pattern="^\d+$" required><br><br>
            
			<label for="beneName">Beneficiary Name: </label><br>
			<input type="text" class="form-control custom-input" name="beneName"><br><br>
					
			<label for="beneBank">Beneficiary Bank: </label><br>
			<input type="text" class="form-control custom-input" name="beneBank" required><br><br>
			
			<label for="beneBranch">Beneficiary Branch: </label><br>
			<input type="text" class="form-control custom-input" name="beneBranch" required><br><br><br>
			
			<input type="submit" value="Add Beneficiary" name="addBeneficiary" class="btn btn-primary custom-btn">
			
		</form>
	
	</div><br><br><br>

</body>
</html>