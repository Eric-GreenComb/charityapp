package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;

public class DonorContribution {
	/*Name              string `protobuf:"bytes,1,opt,name=name" json:"name,omitempty"`
	SmartContractName string `protobuf:"bytes,2,opt,name=smartContractName" json:"smartContractName,omitempty"`
	SmartContractAddr string `protobuf:"bytes,3,opt,name=smartContractAddr" json:"smartContractAddr,omitempty"`
	Amount            uint64 `protobuf:"varint,4,opt,name=amount" json:"amount,omitempty"`
	Timestamp         int64  `protobuf:"varint,5,opt,name=timestamp" json:"timestamp,omitempty"`*/
	
	private String donorid;//捐款id
	
	private String smartContractName;

	private String smartContractAddr;

	private long amount;

	private int timestamp;
	
	private String donorTimeStr;
	
	public String getDonorTimeStr() {
		if(0!=timestamp){
			return DateUtil.getDateFromUnixTime(timestamp);
		}
		
		return donorTimeStr;
	}

	public void setDonorTimeStr(String donorTimeStr) {
		this.donorTimeStr = donorTimeStr;
	}

	public String getDonorid() {
		return donorid;
	}

	public void setDonorid(String donorid) {
		this.donorid = donorid;
	}

	public String getSmartContractName() {
		return smartContractName;
	}

	public void setSmartContractName(String smartContractName) {
		this.smartContractName = smartContractName;
	}

	public String getSmartContractAddr() {
		return smartContractAddr;
	}

	public void setSmartContractAddr(String smartContractAddr) {
		this.smartContractAddr = smartContractAddr;
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

}