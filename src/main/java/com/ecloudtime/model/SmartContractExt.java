package com.ecloudtime.model;

public class SmartContractExt  {

	private long balance;
	
	private String addr;
	
	private SmartContractGo smartContract;

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public SmartContractGo getSmartContract() {
		return smartContract;
	}

	public void setSmartContract(SmartContractGo smartContract) {
		this.smartContract = smartContract;
	}
}
