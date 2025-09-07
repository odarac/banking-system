package com.transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBeneficiaryServlet")
public class UpdateBeneficiaryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String beneID = request.getParameter("beneID");
		String beneName = request.getParameter("beneName");
		String beneAcc = request.getParameter("beneAcc");
		String beneBank = request.getParameter("beneBank");
		String beneBranch = request.getParameter("beneBranch");
		
		boolean isSuccess = BeneficiaryDB.updateBeneficiary(beneID, beneName, beneAcc, beneBank, beneBranch);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (isSuccess == true) {
			out.println("<script type='text/javascript'>alert('Beneficiary details updated successfully');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
		else {
			out.println("<script type='text/javascript'>alert('Updating beneficiary details failed');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
	}

}
