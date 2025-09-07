package com.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaryDB {
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static boolean isSuccess;
	
	public static boolean addBeneficiary(String beneAcc, String beneName, String beneBank, String beneBranch, int cusID) {
			
		try {
				
			con = DBconnection.getConnection();
			
			String sql = "INSERT INTO beneficiary (beneficiaryName, beneficiaryAccNo, beneficiaryBank, beneficiaryBranch, customerID) VALUES (?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, beneName);
			ps.setString(2, beneAcc);
			ps.setString(3, beneBank);
			ps.setString(4, beneBranch);
			ps.setInt(5, cusID);
			
			int rows = ps.executeUpdate();
				
			if (rows > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
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
	
	public static List<Beneficiary> beneficiaryList(int cusID) {
		
		List<Beneficiary> beneList = new ArrayList<Beneficiary>();
		
		try {
			
			con = DBconnection.getConnection();
			
			String sql = "SELECT beneficiaryID, beneficiaryName, beneficiaryAccNo FROM beneficiary WHERE customerID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cusID);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int beneID = rs.getInt(1);
				String beneName = rs.getString(2);
				String beneAcc = rs.getString(3);
				
				beneList.add(new Beneficiary(beneID, beneName, beneAcc));
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
		
		return beneList;
	}
	
	public static List<Beneficiary> beneficiaryDetails(int cusID) {
		
		List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
		
		try {
			
			con = DBconnection.getConnection();
			
			String sql = "SELECT * FROM beneficiary WHERE customerID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cusID);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int beneID = rs.getInt(1);
				String beneName = rs.getString(2);
				String beneAcc = rs.getString(3);
				String bank = rs.getString(4);
				String branch = rs.getString(5);
				
				beneficiaries.add(new Beneficiary(beneID, beneName, beneAcc, bank, branch));
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
		
		return beneficiaries;
	}
	
	public static boolean updateBeneficiary(String id, String name, String acc, String bank, String branch) {
		
		int beneID = Integer.parseInt(id);
		
		try {
			
			con = DBconnection.getConnection();
			
			String sql = "UPDATE beneficiary SET beneficiaryName = ?, beneficiaryAccNo = ?, beneficiaryBank = ?, beneficiaryBranch = ? WHERE beneficiaryID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, acc);
			ps.setString(3, bank);
			ps.setString(4, branch);
			ps.setInt(5, beneID);
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
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
	
	public static boolean deleteBeneficiary(String id) {
		
		int beneID = Integer.parseInt(id);
		
		try {
			
			con = DBconnection.getConnection();
			
			String sql = "DELETE FROM beneficiary WHERE beneficiaryID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, beneID);
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
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

}
