package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.MoneyUtil;

public class BargainHistory {

	/*,
    "message": "{\"addr\":\"bargain01:8fcc58ea7ed212f7c1ba359d15bea144e67c390044d953797548cf67fd62534a\",\
    "trans\":[{\"amount\":10000000,\"timestamp\":1487820879}]
*/
	private long amount;
	private int timestamp;
	private String amountStr;
	private String timestampStr;
	public String getAmountStr() {
		if(0!=amount){
    		return MoneyUtil.ccToMoneyFormat(amount,"yuan");
    	}
		return amountStr;
	}
	public String getTimestampStr() {
		if(0!=timestamp){
			return DateUtil.getDateFromUnixTime(timestamp);
		}
		return timestampStr;
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
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	public void setTimestampStr(String timestampStr) {
		this.timestampStr = timestampStr;
	}
}
