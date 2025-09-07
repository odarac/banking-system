<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>View Beneficiaries</title>
	
	<link href="styles.css" rel="stylesheet">
	<!-- Bootstrap CSS -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	

</head>

<body>

	<div class="container mt-5">

		<h2 class="mb-4 text-center">View Beneficiary</h2><br>			
			
			<table class="table table-striped">
			<tr>
				<th>Beneficiary ID</th>
				<th>Beneficiary Name</th>
				<th>Beneficiary Account Number</th>
				<th>Beneficiary Bank</th>
				<th>Beneficiary Branch</th>
			</tr>			
			
			<c:forEach var="bene" items="${beneficiaries}"> 
	
			<tr>
				<td>${bene.beneficiaryID}</td>
				<td>${bene.beneficiaryName}</td>
				<td>${bene.accNo}</td>
				<td>${bene.bank}</td>
				<td>${bene.branch}</td>
				
				<c:url value="UpdateBeneficiary.jsp" var="beneUpdate">
					<c:param name="id" value="${bene.beneficiaryID}"></c:param>
					<c:param name="name" value="${bene.beneficiaryName}"></c:param>
					<c:param name="acc" value="${bene.accNo}"></c:param>
					<c:param name="bank" value="${bene.bank}"></c:param>
					<c:param name="branch" value="${bene.branch}"></c:param>
				</c:url>
				
				<td><a href="${beneUpdate}"><input type="button" value="Update" name="updateBeneficiary" class="btn btn-primary custom-btn"></a></td>
				
				<c:url value="DeleteBeneficiary.jsp" var="beneDelete">
					<c:param name="id" value="${bene.beneficiaryID}"></c:param>
					<c:param name="name" value="${bene.beneficiaryName}"></c:param>
					<c:param name="acc" value="${bene.accNo}"></c:param>
					<c:param name="bank" value="${bene.bank}"></c:param>
					<c:param name="branch" value="${bene.branch}"></c:param>
				</c:url>
				
				<td><a href="${beneDelete}"><input type="button" value="Delete" name="deleteBeneficiary" class="btn btn-primary custom-btn"></a></td>								
			</tr>
		
			</c:forEach>
		
			</table>				
	
	
	</div>


</body>
</html>