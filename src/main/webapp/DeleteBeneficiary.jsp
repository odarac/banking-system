<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Delete Beneficiary</title>
	
	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	
	<style>
		.custom-form::after {
		  content: "";
		  clear: both;
		  display: table;
		}
	</style>
	
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

		<h2 class="mb-4 text-center">Delete Beneficiary</h2><br>
			
			
			<form method="post" action="deleteBeneficiary"  class="custom-form">
			
				<h5>Are you sure you want to delete the below beneficiary from your beneficiary list?</h5><br>
			
				<label>Beneficiary ID: </label>
				<input type="text" class="form-control custom-input" name="beneID" value="<%= id %>" readonly><br><br>
				
				<label>Beneficiary Name: </label>
				<input type="text" class="form-control custom-input" name="beneName" value="<%= name %>" readonly><br><br>
			
				<label>Beneficiary Account: </label>
				<input type="text" class="form-control custom-input" name="beneAcc" value="<%= acc %>" readonly><br><br>
						
				<label>Beneficiary Bank: </label>
				<input type="text" class="form-control custom-input" name="beneBank" value="<%= bank %>" readonly><br><br>
				
				<label>Beneficiary Branch: </label>
				<input type="text" class="form-control custom-input" name="beneBranch" value="<%= branch %>" readonly><br><br>
				
				<input type="submit" value="Yes, Delete Beneficiary" name="deleteBeneficiary" class="btn btn-primary custom-btn">
				<a href="MakeTransaction.jsp"><input type="button" name="reject" value="No" class="btn btn-secondary custom-btn" style="float: right;"></a>
			
			</form>		
			
	</div>
	
	<br><br><br>

</body>
</html>