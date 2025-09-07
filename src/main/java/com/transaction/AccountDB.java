package com.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDB {
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	
	public static List<Account> accountList(int cusID) {
		
		List<Account> accList = new ArrayList<Account>();
		
		try {
			
			con = DBconnection.getConnection();
			
			String sql = "SELECT accNumber FROM account WHERE customerID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cusID);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String accno = rs.getString(1);
				
				accList.add(new Account(accno));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return accList;
	}
}
