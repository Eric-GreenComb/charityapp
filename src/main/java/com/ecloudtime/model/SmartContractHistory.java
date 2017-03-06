package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.MoneyUtil;

public class SmartContractHistory {
	private String bargainName;
	private String bargainAddr;
	private String type;
	private long amount;
	private String amountStr;
	private int timestamp;
	private String status;//状态
	private String timestampStr;
	
	public String getAmountStr() {
		if(0!=amount){
    		return MoneyUtil.ccToMoneyFormat(amount,"yuan");
    	}
		return amountStr;
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	public String getTimestampStr() {
		if(0!=this.timestamp){
			return DateUtil.getDateFromUnixTime(this.timestamp).substring(0, 10).replace("-", ".");
		}else{
			return timestampStr;
		}
	}
	public void setTimestampStr(String timestampStr) {
		this.timestampStr = timestampStr;
	}
	public String getBargainName() {
		return bargainName;
	}
	public void setBargainName(String bargainName) {
		this.bargainName = bargainName;
	}
	public String getBargainAddr() {
		return bargainAddr;
	}
	public void setBargainAddr(String bargainAddr) {
		this.bargainAddr = bargainAddr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
/*
	BargainName string `protobuf:"bytes,1,opt,name=bargainName" json:"bargainName,omitempty"`
	BargainAddr string `protobuf:"bytes,2,opt,name=bargainAddr" json:"bargainAddr,omitempty"`
	Type        string `protobuf:"bytes,3,opt,name=type" json:"type,omitempty"`
	Amount      string `protobuf:"bytes,4,opt,name=amount" json:"amount,omitempty"`
	Timestamp   int64  `protobuf:"varint,5,opt,name=timestamp" json:"timestamp,omitempty"`*/
}
