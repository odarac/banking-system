package com.transaction;

public class Transaction {
	
	private int transactionID;
	private String senderAcc;
	private int beneficiaryID;
	private double amount;
	
	public Transaction(int transactionID, String senderAcc, int beneficiaryID, double amount) {
		this.transactionID = transactionID;
		this.senderAcc = senderAcc;
		this.beneficiaryID = beneficiaryID;
		this.amount = amount;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public String getSenderAcc() {
		return senderAcc;
	}

	public int getBeneficiaryID() {
		return beneficiaryID;
	}

	public double getAmount() {
		return amount;
	}
	
	
	
		
	
}
