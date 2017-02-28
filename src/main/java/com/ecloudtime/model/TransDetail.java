package com.ecloudtime.model;

import com.ecloudtime.utils.MoneyUtil;

public class TransDetail {
	private String txid;//cc交易id
	private String transId;//交易id
	private String type;//交易类型 捐款或是提款
	private String transTime;//交易时间
	private String contractId;//合约id
	private String contractName;//合约名称
	private long amount;
	private String amountStr;
	
	public String getAmountStr() {
		if(0!=amount){
    		return MoneyUtil.ccToMoneyFormat(amount,"yuan");
    	}
		return amountStr;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
