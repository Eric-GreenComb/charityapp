package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.MoneyUtil;

public class DonorContribution implements Cloneable{
	/*Name              string `protobuf:"bytes,1,opt,name=name" json:"name,omitempty"`
	SmartContractName string `protobuf:"bytes,2,opt,name=smartContractName" json:"smartContractName,omitempty"`
	SmartContractAddr string `protobuf:"bytes,3,opt,name=smartContractAddr" json:"smartContractAddr,omitempty"`
	Amount            uint64 `protobuf:"varint,4,opt,name=amount" json:"amount,omitempty"`
	Timestamp         int64  `protobuf:"varint,5,opt,name=timestamp" json:"timestamp,omitempty"`*/
	
	private String donorid;//捐款id
	
	private String smartContractName;

	private String smartContractAddr;
	
	private SmartContract smartContract;
	
	private SmartContractExt  smartContractExt;

	private long amount;
	
	private String amountStr;

	private int timestamp;
	
	private int donorNumber;
	
	private String donorTimeStr;
	
	public String getAmountStr() {
		if(0!=getAmount()){
    		return MoneyUtil.ccToMoneyFormat(getAmount(),"yuan");
    	}
    	return "0.00";
	}

	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

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

	public int getDonorNumber() {
		return donorNumber;
	}

	public void setDonorNumber(int donorNumber) {
		this.donorNumber = donorNumber;
	}
	
	public SmartContract getSmartContract() {
		return smartContract;
	}

	public void setSmartContract(SmartContract smartContract) {
		this.smartContract = smartContract;
	}
	
	public SmartContractExt getSmartContractExt() {
		return smartContractExt;
	}

	public void setSmartContractExt(SmartContractExt smartContractExt) {
		this.smartContractExt = smartContractExt;
	}

	public DonorContribution clone(){
		DonorContribution o = null;
		try{
			o = (DonorContribution)super.clone(); 
			}catch(CloneNotSupportedException e){
				e.printStackTrace();
				}
		return o; 
		} 
	

}