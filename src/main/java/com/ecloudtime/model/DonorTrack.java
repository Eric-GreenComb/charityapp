package com.ecloudtime.model;

public class DonorTrack {
  
	private String donorid;//捐款id
	
	private String drawid;//取款id

	private String accountName;

	private String accountAddr;

	private long amount;
	
	private long donorAmount;//捐款总数

	private int timestamp;
	
	private String type;//donate :0    draw :1  channel:2   fund:3

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountAddr() {
		return accountAddr;
	}

	public void setAccountAddr(String accountAddr) {
		this.accountAddr = accountAddr;
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

	public String getDonorid() {
		return donorid;
	}

	public void setDonorid(String donorid) {
		this.donorid = donorid;
	}

	public String getType() {
		if("".equals(type)||null==type){
			type="0";
		}
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getDonorAmount() {
		return donorAmount;
	}

	public void setDonorAmount(long donorAmount) {
		this.donorAmount = donorAmount;
	}

	public String getDrawid() {
		return drawid;
	}

	public void setDrawid(String drawid) {
		this.drawid = drawid;
	}
	
	 /*Name        string `protobuf:"bytes,1,opt,name=name" json:"name,omitempty"`
		AccountName string `protobuf:"bytes,2,opt,name=accountName" json:"accountName,omitempty"`
		AccountAddr string `protobuf:"bytes,3,opt,name=accountAddr" json:"accountAddr,omitempty"`
		Amount      uint64 `protobuf:"varint,4,opt,name=amount" json:"amount,omitempty"`
		Timestamp   int64  `protobuf:"varint,5,opt,name=timestamp" json:"timestamp,omitempty"`*/

}