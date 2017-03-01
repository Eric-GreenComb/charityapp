package com.ecloudtime.model;

public class FundFlow {

/*	CREATE TABLE `sys_fund_flow` (
			  `txid` varchar(20) NOT NULL,
			  `trans_id` varchar(20) DEFAULT NULL,
			  `type` varchar(10) DEFAULT NULL,
			  `trans_time` varchar(20) DEFAULT NULL,
			  `contract_id` varchar(20) DEFAULT NULL,
			  `contract_name` varchar(20) DEFAULT NULL,
			  PRIMARY KEY (`txid`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流水表'*/

	private String txid;
	private String transId;
	private String type;
	private String transTime;
	private String contractId;
	private String contractName;
	private String transMoney;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getTransMoney() {
		return transMoney;
	}
	public void setTransMoney(String transMoney) {
		this.transMoney = transMoney;
	}
}
