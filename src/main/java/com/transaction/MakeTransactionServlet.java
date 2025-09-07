package com.transaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeTransactionServlet")
public class MakeTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//customer's customerID is user as the session ID in a session
		String cID = request.getParameter("sessionID");
		
		int cusID = Integer.parseInt(cID);
		
		String type = request.getParameter("type");
		
		if (type.equals("transfer")) {
			
			List<Beneficiary> beneList = BeneficiaryDB.beneficiaryList(cusID);
			request.setAttribute("beneList", beneList);
			
			List<Account> accList = AccountDB.accountList(cusID);
			request.setAttribute("accList", accList);
			
			RequestDispatcher rd1 = request.getRequestDispatcher("MakeTransfer.jsp");
			rd1.forward(request, response);
			
		}
		else if (type.equals("payment")) {
			
			List<Beneficiary> beneList = BeneficiaryDB.beneficiaryList(0);
			request.setAttribute("beneList", beneList);
			
			List<Account> accList = AccountDB.accountList(cusID);
			request.setAttribute("accList", accList);
			
			RequestDispatcher rd2 = request.getRequestDispatcher("MakePayment.jsp");
			rd2.forward(request, response);
			
		}
	}
	
	
	
	
	

}
