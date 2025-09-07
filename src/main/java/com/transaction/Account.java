package com.transaction;

public class Account {
	
	String accno;
	int cusID;
	
	public Account(String accno, int cusID) {
		this.accno = accno;
		this.cusID = cusID;
	}

	public Account(String accno) {
		this.accno = accno;
	}



	public String getAccno() {
		return accno;
	}

	public int getCusID() {
		return cusID;
	}
	
	
}
