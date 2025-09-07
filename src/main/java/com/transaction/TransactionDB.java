package com.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDB {
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static boolean storeTransactionDetails(String senderAcc, String beneID, String amnt, int cusID) {
		
		boolean isSuccess = false;
		int beneficiaryID = Integer.parseInt(beneID);
		double amount = Double.parseDouble(amnt);
		
		try {			
			con = DBconnection.getConnection();
			
			String sql = "INSERT INTO bankdb.transaction (senderAcc, beneficiaryID, amount, customerID) values (?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, senderAcc);
			ps.setInt(2, beneficiaryID);
			ps.setDouble(3, amount);
			ps.setInt(4, cusID);
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				isSuccess = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return isSuccess;
		
	}
	
	public static List<Transaction> getTransactionDetails(int cusID) {
		
		List<Transaction> transactionList = new ArrayList<Transaction>();
		
		
		try {
			con = DBconnection.getConnection();
			
			String sql = "SELECT * FROM transaction WHERE customerID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cusID);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int transacID = rs.getInt(1);
				String senderAcc = rs.getString(2);
				int beneID = rs.getInt(3);
				Double amount = rs.getDouble(4);
				
				transactionList.add(new Transaction(transacID, senderAcc, beneID, amount));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return transactionList;
	}
	
}
