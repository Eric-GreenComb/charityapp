package com.ecloudtime.model;

public class FundationTranTrack {
	
	private String donorid;
	
	private String drawid;//取款id

	private String accountName;

	private String accountAddr;

	private long amount;
	
	private long donorAmount;//捐款总数

	private int timestamp;
	
	private String type;//donate :0    draw :1  channel:2   fund:3

	public String getDonorid() {
		return donorid;
	}

	public void setDonorid(String donorid) {
		this.donorid = donorid;
	}

	public String getDrawid() {
		return drawid;
	}

	public void setDrawid(String drawid) {
		this.drawid = drawid;
	}

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

	public long getDonorAmount() {
		return donorAmount;
	}

	public void setDonorAmount(long donorAmount) {
		this.donorAmount = donorAmount;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	


}
