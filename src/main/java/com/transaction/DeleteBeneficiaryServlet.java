package com.transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteBeneficiaryServlet")
public class DeleteBeneficiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String beneID = request.getParameter("beneID");
		
		boolean isSuccess = BeneficiaryDB.deleteBeneficiary(beneID);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (isSuccess == true) {
			out.println("<script type='text/javascript'>alert('Beneficiary deleted successfully');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
		else {
			out.println("<script type='text/javascript'>alert('Deleting beneficiary failed');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
	}

}
