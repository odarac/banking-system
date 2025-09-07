package com.transaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewTransactionServlet")
public class ViewTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//customer's customerID is user as the session ID in a session
		String cID = request.getParameter("sessionID");
						
		int cusID = Integer.parseInt(cID);
				
		List<Transaction> transacList = TransactionDB.getTransactionDetails(cusID);
		request.setAttribute("pastTransaction", transacList);
		
		RequestDispatcher rd = request.getRequestDispatcher("PastTransactions.jsp");
		rd.forward(request, response);
	}

}
