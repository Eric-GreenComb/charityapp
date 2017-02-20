package com.ecloudtime.model;

import com.ecloudtime.utils.MoneyUtil;

public class SmartContractExt  {
	/* string addr = 1;
	    uint64 balance = 2;
	    uint64 total = 3;
	    uint64 validTotal = 4;
	    uint64 donateNumber = 5;
	    SmartContract smartContract = 6;*/
	
	private String addr;
	private long balance;
	private long total;
	private long validTotal;
	private long donateNumber;
	private SmartContract smartContract;
	private String pic;
	
	private String validTotalStr;
	
	public String getValidTotalStr() {
		if(0!=this.getValidTotal()){
    		return MoneyUtil.ccToMoneyFormat(getValidTotal(),"yuan");
    	}
		return validTotalStr;
	}
	public void setValidTotalStr(String validTotalStr) {
		this.validTotalStr = validTotalStr;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getValidTotal() {
		return validTotal;
	}
	public void setValidTotal(long validTotal) {
		this.validTotal = validTotal;
	}
	public long getDonateNumber() {
		return donateNumber;
	}
	public void setDonateNumber(long donateNumber) {
		this.donateNumber = donateNumber;
	}
	public SmartContract getSmartContract() {
		return smartContract;
	}
	public void setSmartContract(SmartContract smartContract) {
		this.smartContract = smartContract;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
}
