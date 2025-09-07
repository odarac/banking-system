package com.transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SubmitTransactionServlet")
public class SubmitTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//customer's customerID is user as the session ID in a session
		String cID = request.getParameter("sessionID");
				
		int cusID = Integer.parseInt(cID);
		
		String senderAcc = request.getParameter("senderAcc");
		String amount = request.getParameter("amount");
		String beneficiaryID = request.getParameter("beneficiary");
		
		boolean isSuccess;
		
		isSuccess = TransactionDB.storeTransactionDetails(senderAcc, beneficiaryID, amount, cusID);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (isSuccess == true) {
			out.println("<script type='text/javascript'>alert('Transaction successful');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
		else {
			out.println("<script type='text/javascript'>alert('Transaction failed');");
			out.println("location='MakeTransaction.jsp';</script>");
		}
	}

}
