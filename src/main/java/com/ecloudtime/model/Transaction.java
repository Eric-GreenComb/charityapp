package com.ecloudtime.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.ecloudtime.utils.Base64Util;
import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.MoneyUtil;

public class Transaction implements java.io.Serializable{
	private static final long serialVersionUID = -1943961352036134112L;
	
	private int type;

	private String chaincodeID;

	private String payload;

	private String transMoney;
	
	private String txid;

	private Timestamp timestamp;
	
	private String tranGenTime;
	
	public String getTranGenTime() {
		if(null!=timestamp){
			return DateUtil.getDateFromUnixTime(timestamp.getSeconds());
		}
		return tranGenTime;
	}
	
	public String getTransMoney() {
		if(!StringUtils.isEmpty(payload)){
			String temp=Base64Util.getFromBase64(payload);
			if(temp.indexOf(":::")!=-1)
			return MoneyUtil.getMoneyFromPayload(temp);
		}
		return "--";
	}

	public void setTransMoney(String transMoney) {
		this.transMoney = transMoney;
	}

	public void setTranGenTime(String tranGenTime) {
		this.tranGenTime = tranGenTime;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setChaincodeID(String chaincodeID) {
		this.chaincodeID = chaincodeID;
	}

	public String getChaincodeID() {
		return this.chaincodeID;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return this.payload;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getTxid() {
		return this.txid;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}
	
	
	public static void main(String[] args) {
		     String regEx = "count(\\d+)(df)";  
		     regEx=":::(\\d+):::";
	         String s = "count000dfdfsdffaaaa1";  
	         s="12111:::1000:::_wwwww:::2000:::";
	         Pattern pat = Pattern.compile(regEx);  
	         Matcher mat = pat.matcher(s);  
	         if(mat.find()){
	            System.out.println(mat.group(1));
	         }
	         System.out.println(s.indexOf(":::"));
	}
}
