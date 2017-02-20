package com.ecloudtime.model;

public class ProcessDrawed {

/*	DrawUUID          string `protobuf:"bytes,1,opt,name=drawUUID" json:"drawUUID,omitempty"`
	SmartContractAddr string `protobuf:"bytes,2,opt,name=smartContractAddr" json:"smartContractAddr,omitempty"`
	BargainAddr       string `protobuf:"bytes,3,opt,name=bargainAddr" json:"bargainAddr,omitempty"`
	BargainName       string `protobuf:"bytes,4,opt,name=bargainName" json:"bargainName,omitempty"`
	Amount            uint64 `protobuf:"varint,5,opt,name=amount" json:"amount,omitempty"`
	DonorName         string `protobuf:"bytes,6,opt,name=donorName" json:"donorName,omitempty"`
	AcceptName        string `protobuf:"bytes,7,opt,name=acceptName" json:"acceptName,omitempty"`
	Timestamp         int64  `protobuf:"varint,8,opt,name=timestamp" json:"timestamp,omitempty"`
	Remark            string `protobuf:"bytes,9,opt,name=remark" json:"remark,omitempty"`
}
*/
	
	private String drawUUID;
	private String smartContractAddr;
	private String bargainAddr;
	private String bargainName;
	private long amount;
	private String donorName;
	private String acceptName;
	private int timestamp;
	private String remark;
	public String getDrawUUID() {
		return drawUUID;
	}
	public void setDrawUUID(String drawUUID) {
		this.drawUUID = drawUUID;
	}
	public String getSmartContractAddr() {
		return smartContractAddr;
	}
	public void setSmartContractAddr(String smartContractAddr) {
		this.smartContractAddr = smartContractAddr;
	}
	public String getBargainAddr() {
		return bargainAddr;
	}
	public void setBargainAddr(String bargainAddr) {
		this.bargainAddr = bargainAddr;
	}
	public String getBargainName() {
		return bargainName;
	}
	public void setBargainName(String bargainName) {
		this.bargainName = bargainName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getAcceptName() {
		return acceptName;
	}
	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
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
	
	
}
