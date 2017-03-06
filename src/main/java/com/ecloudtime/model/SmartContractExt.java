package com.ecloudtime.model;

import com.ecloudtime.utils.MoneyUtil;

public class SmartContractExt  {
	/* string addr = 1;
	    uint64 balance = 2;
	    uint64 total = 3;
	    uint64 validTotal = 4;
	    uint64 donateNumber = 5;
	    SmartContract smartContract = 6;*/
	
	private String addr;//合约的地址
	private long balance;//合约的余额
	
	private long total;//总捐款
	private long validTotal;//已筹集的捐款
	private long donateNumber;//合约的总捐款爱心数量
	private SmartContract smartContract;
	private String canDonateNumberStr;//该合约还可以捐款的钱数
	private String channelFeeStr;//合约的总渠道费万元
	private String channelFeeYuan;//合约的总渠道费元
	private String fundFeeStr;//合约的总基金费
	private String fundFeeYuan;//合约的总基金费
	private String pic;//合约的存储图片地址
	private String totalStr;//总捐款 万元
	private String totalYuan;//总捐款 元
	private String validTotalStr;//已筹集善款  万元
	private String validTotalYuan;//已筹集善款 元
	private String balanceStr;
	private String balanceYuan;
	
	public String getBalanceStr() {
		if(0!=balance){
    		return MoneyUtil.ccToMoneyFormat(balance,"wan");
    	}
		return "0";
	}
	public String getBalanceYuan() {
		if(0!=balance){
    		return MoneyUtil.ccToMoneyFormat(balance,"yuan");
    	}
		return "0";
	}

	public void setBalanceYuan(String balanceYuan) {
		this.balanceYuan = balanceYuan;
	}

	public String getChannelFeeStr() {
		if(0!=this.getTotal()){
			long channelFeeTemp=smartContract.getChannelFee();
			long channelFee=(getTotal()/1000)*channelFeeTemp;
			return MoneyUtil.ccToMoneyFormat(channelFee,"wan");
		}
		return channelFeeStr;
	}
	
	public String getFundFeeStr() {
		if(0!=this.getTotal()){
			long fundFeeTemp=smartContract.getFundManangerFee();
			long fundFee=(getTotal()/1000)*fundFeeTemp;
			return MoneyUtil.ccToMoneyFormat(fundFee,"wan");
		}
		return fundFeeStr;
	}
	
	public String getChannelFeeYuan() {
		if(0!=this.getTotal()){
			long channelFeeTemp=smartContract.getChannelFee();
			long channelFee=(getTotal()/1000)*channelFeeTemp;
			return MoneyUtil.ccToMoneyFormat(channelFee,"yuan");
		}
		return channelFeeYuan;
	}

	public String getFundFeeYuan() {
		if(0!=this.getTotal()){
			long fundFeeTemp=smartContract.getFundManangerFee();
			long fundFee=(getTotal()/1000)*fundFeeTemp;
			return MoneyUtil.ccToMoneyFormat(fundFee,"yuan");
		}
		return fundFeeYuan;
	}
	

	public String getTotalStr() {
		if(0!=this.getTotal()){
    		return MoneyUtil.ccToMoneyFormat(getTotal(),"wan");
    	}
		return "0";
	}
	public void setTotalStr(String totalStr) {
		this.totalStr = totalStr;
	}
	public String getTotalYuan() {
		if(0!=this.getTotal()){
    		return MoneyUtil.ccToMoneyFormat(getTotal(),"yuan");
    	}
		return totalYuan;
	}
	public void setTotalYuan(String totalYuan) {
		this.totalYuan = totalYuan;
	}
	
	public void setChannelFeeStr(String channelFeeStr) {
		this.channelFeeStr = channelFeeStr;
	}
	public void setFundFeeStr(String fundFeeStr) {
		this.fundFeeStr = fundFeeStr;
	}
	public String getCanDonateNumberStr() {
		if(0!=smartContract.getGoal()&&smartContract.getGoal()>this.getTotal()){
			long canDonateNumber=smartContract.getGoal()-this.getTotal();
			return MoneyUtil.ccToMoneyFormat(canDonateNumber,"yuan");
		}
		
		return "0";
	}
	public void setCanDonateNumberStr(String canDonateNumberStr) {
		this.canDonateNumberStr = canDonateNumberStr;
	}
	public void setChannelFeeYuan(String channelFeeYuan) {
		this.channelFeeYuan = channelFeeYuan;
	}

	public void setFundFeeYuan(String fundFeeYuan) {
		this.fundFeeYuan = fundFeeYuan;
	}
	
	public void setBalanceStr(String balanceStr) {
		this.balanceStr = balanceStr;
	}
	
	public String getValidTotalYuan() {
		if(0!=this.getValidTotal()){
    		return MoneyUtil.ccToMoneyFormat(getValidTotal(),"yuan");
    	}
		return validTotalYuan;
	}
	public void setValidTotalYuan(String validTotalYuan) {
		this.validTotalYuan = validTotalYuan;
	}
	public String getValidTotalStr() {
		if(0!=this.getValidTotal()){
    		return MoneyUtil.ccToMoneyFormat(getValidTotal(),"wan");
    	}
		return "0";
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
