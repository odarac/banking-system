package com.transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeneficiaryServlet
 */
@WebServlet({ "/BeneficiaryServlet" })
public class BeneficiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//customer's customerID is user as the session ID in a session
		String cID = request.getParameter("sessionID");
				
		int cusID = Integer.parseInt(cID);
		
		String beneficiaryAcc = request.getParameter("beneAcc");
		String name = request.getParameter("beneName");
		String bank = request.getParameter("beneBank");
		String branch = request.getParameter("beneBranch");
		
		boolean isSuccess = BeneficiaryDB.addBeneficiary(beneficiaryAcc, name, bank, branch, cusID);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (isSuccess == true) {
			out.println("<script type='text/javascript'>alert('Beneficiary added successfully');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
		else {
			out.println("<script type='text/javascript'>alert('Adding new beneficiary failed');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
	}


}
