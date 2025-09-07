<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Beneficiary</title>
	
	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String acc = request.getParameter("acc");
		String bank = request.getParameter("bank");
		String branch = request.getParameter("branch");
	%>

		<h2 class="mb-4 text-center">Update Beneficiary</h2><br>
			
			
			<form method="post" action="updateBeneficiary" class="custom-form">
			
				<label for="beneID">Beneficiary ID: </label><br>
				<input type="text" class="form-control custom-input" name="beneID" value="<%= id %>" readonly><br><br>
				
				<label for="beneName">Beneficiary Name: </label><br>
				<input type="text" class="form-control custom-input" name="beneName" value="<%= name %>"><br><br>
			
				<label for="beneAcc">Beneficiary Account: </label><br>
				<input type="text" class="form-control custom-input" name="beneAcc" value="<%= acc %>"><br><br>
						
				<label for="beneBank">Beneficiary Bank: </label><br>
				<input type="text" class="form-control custom-input" name="beneBank" value="<%= bank %>"><br><br>
				
				<label for="beneBranch">Beneficiary Branch: </label><br>
				<input type="text" class="form-control custom-input" name="beneBranch" value="<%= branch %>"><br><br>
				
				<input type="submit" value="Update Beneficiary Details" name="updateBeneficiary" class="btn btn-primary custom-btn">
			
			</form>			
	
	
	</div>
	
	<br><br><br>
	
</body>
</html>