package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.MoneyUtil;

public class ProcessDonored {
	private String donorUUID;
	private String donorAddr;
	private String smartContractAddr;
	private String smartContractName;
	private String fundName;
	private String channelName;
	private long amount;
	private long smartContractAmount;
	private long channelAmount;
	private long fundAmount;
	private int timestamp;
	private String donorTimeStr;
	private String remark;
	
	private String amountStr;
	private String smartContractAmountStr;
	private String channelAmountStr;
	private String fundAmountStr;

	public String getAmountStr() {
		if(0!=getAmount()){
    		return MoneyUtil.ccToMoneyFormat(getAmount(),"yuan");
    	}
		
		return amountStr;
	}
	
	public String getSmartContractAmountStr() {
		if(0!=getSmartContractAmount()){
    		return MoneyUtil.ccToMoneyFormat(getSmartContractAmount(),"yuan");
    	}
		
		return smartContractAmountStr;
	}
	
	public String getChannelAmountStr() {
		if(0!=getChannelAmount()){
    		return MoneyUtil.ccToMoneyFormat(getChannelAmount(),"yuan");
    	}
		return channelAmountStr;
	}
	
	public String getFundAmountStr() {
		if(0!=getFundAmount()){
    		return MoneyUtil.ccToMoneyFormat(getFundAmount(),"yuan");
    	}
		return fundAmountStr;
	}


	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

	
	public void setSmartContractAmountStr(String smartContractAmountStr) {
		this.smartContractAmountStr = smartContractAmountStr;
	}


	public void setChannelAmountStr(String channelAmountStr) {
		this.channelAmountStr = channelAmountStr;
	}

	

	public void setFundAmountStr(String fundAmountStr) {
		this.fundAmountStr = fundAmountStr;
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

	public String getDonorUUID() {
		return donorUUID;
	}

	public void setDonorUUID(String donorUUID) {
		this.donorUUID = donorUUID;
	}

	public String getDonorAddr() {
		return donorAddr;
	}

	public void setDonorAddr(String donorAddr) {
		this.donorAddr = donorAddr;
	}

	public String getSmartContractAddr() {
		return smartContractAddr;
	}

	public void setSmartContractAddr(String smartContractAddr) {
		this.smartContractAddr = smartContractAddr;
	}

	public String getSmartContractName() {
		return smartContractName;
	}

	public void setSmartContractName(String smartContractName) {
		this.smartContractName = smartContractName;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getSmartContractAmount() {
		return smartContractAmount;
	}

	public void setSmartContractAmount(long smartContractAmount) {
		this.smartContractAmount = smartContractAmount;
	}

	public long getChannelAmount() {
		return channelAmount;
	}

	public void setChannelAmount(long channelAmount) {
		this.channelAmount = channelAmount;
	}

	public long getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(long fundAmount) {
		this.fundAmount = fundAmount;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/*
	 * DonorUUID string `protobuf:"bytes,1,opt,name=donorUUID"
	 * json:"donorUUID,omitempty"` DonorAddr string
	 * `protobuf:"bytes,2,opt,name=donorAddr" json:"donorAddr,omitempty"`
	 * SmartContractAddr string `protobuf:"bytes,3,opt,name=smartContractAddr"
	 * json:"smartContractAddr,omitempty"` SmartContractName string
	 * `protobuf:"bytes,4,opt,name=smartContractName"
	 * json:"smartContractName,omitempty"` FundName string
	 * `protobuf:"bytes,5,opt,name=fundName" json:"fundName,omitempty"`
	 * ChannelName string `protobuf:"bytes,6,opt,name=channelName"
	 * json:"channelName,omitempty"` Amount uint64
	 * `protobuf:"varint,7,opt,name=amount" json:"amount,omitempty"`
	 * SmartContractAmount uint64
	 * `protobuf:"varint,8,opt,name=smartContractAmount"
	 * json:"smartContractAmount,omitempty"` ChannelAmount uint64
	 * `protobuf:"varint,9,opt,name=channelAmount"
	 * json:"channelAmount,omitempty"` FundAmount uint64
	 * `protobuf:"varint,10,opt,name=fundAmount" json:"fundAmount,omitempty"`
	 * Timestamp int64 `protobuf:"varint,11,opt,name=timestamp"
	 * json:"timestamp,omitempty"` Remark string
	 * `protobuf:"bytes,12,opt,name=remark" json:"remark,omitempty"`
	 */

}
