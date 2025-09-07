package com.transaction;

public class Beneficiary {
	
	private int beneficiaryID;
	private String beneficiaryName, accNo, bank, branch;
	private int cusID;
	
	
	public Beneficiary(int beneficiaryID, String beneficiaryName, String accNo) {
		this.beneficiaryID = beneficiaryID;
		this.beneficiaryName = beneficiaryName;
		this.accNo = accNo;
	}

	//for payments
	public Beneficiary(int beneficiaryID, String beneficiaryName, String accNo, String bank, String branch) {
		this.beneficiaryID = beneficiaryID;
		this.beneficiaryName = beneficiaryName;
		this.accNo = accNo;
		this.bank = bank;
		this.branch = branch;
	}
	
	//for transfers
	public Beneficiary(int beneficiaryID, String beneficiaryName, String accNo, String bank, String branch, int cusID) {
		this.beneficiaryID = beneficiaryID;
		this.beneficiaryName = beneficiaryName;
		this.accNo = accNo;
		this.bank = bank;
		this.branch = branch;
		this.cusID = cusID;
	}

	public int getBeneficiaryID() {
		return beneficiaryID;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public String getAccNo() {
		return accNo;
	}

	public String getBank() {
		return bank;
	}

	public String getBranch() {
		return branch;
	}

	public int getCusID() {
		return cusID;
	}
	
	
	
}
