package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;

public class Transaction implements java.io.Serializable{
	private static final long serialVersionUID = -1943961352036134112L;
	
	private int type;

	private String chaincodeID;

	private String payload;

	private String txid;

	private Timestamp timestamp;
	
	private String tranGenTime;
	
	public String getTranGenTime() {
		if(null!=timestamp){
			return DateUtil.getDateFromUnixTime(timestamp.getSeconds());
		}
		return tranGenTime;
	}

	public void setTranGenTime(String tranGenTime) {
		this.tranGenTime = tranGenTime;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setChaincodeID(String chaincodeID) {
		this.chaincodeID = chaincodeID;
	}

	public String getChaincodeID() {
		return this.chaincodeID;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return this.payload;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getTxid() {
		return this.txid;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}
}
