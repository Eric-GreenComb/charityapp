package com.ecloudtime.model;

import java.util.List;

public class Account {

	private String addr;
	private String balance;
	private String rsaPublicKey;
	private List<String> coinKey;
	/*
	 * Map<String,TX_TXOUT> txouts=new HashMap<String,TX_TXOUT>();
	 * public Map<String, TX_TXOUT> getTxouts() {
		return txouts;
	}
	public void setTxouts(Map<String, TX_TXOUT> txouts) {
		this.txouts = txouts;
	}*/
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getRsaPublicKey() {
		return rsaPublicKey;
	}
	public void setRsaPublicKey(String rsaPublicKey) {
		this.rsaPublicKey = rsaPublicKey;
	}
	public List<String> getCoinKey() {
		return coinKey;
	}
	public void setCoinKey(List<String> coinKey) {
		this.coinKey = coinKey;
	}
	
	
}
