package com.ecloudtime.model;

import java.util.List;

import org.springframework.util.StringUtils;

import com.ecloudtime.utils.MoneyUtil;

public class Foundation {

	/*
   type Foundation struct {
		Addr           string                `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"`
		Id             string                `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"`
		Name           string                `protobuf:"bytes,3,opt,name=name" json:"name,omitempty"`
		Total          uint64                `protobuf:"varint,4,opt,name=total" json:"total,omitempty"`
		ValidTotal     uint64                `protobuf:"varint,5,opt,name=validTotal" json:"validTotal,omitempty"`
		Balance        uint64                `protobuf:"varint,6,opt,name=balance" json:"balance,omitempty"`
		SmartContracts []string              `protobuf:"bytes,7,rep,name=smartContracts" json:"smartContracts,omitempty"`
		Fees           []*FoundationFeeTrack `protobuf:"bytes,8,rep,name=fees" json:"fees,omitempty"`
	}
*/
	
	private String addr;
	private String name;
	private String id;
	private String contracts;//contracts
	private long total;
	private long validTotal;
	private long balance;
	private String totalStr;
	private String validTotalStr;
	private String balanceStr;
	private int smartContractLen;
	private long fundManangerFee;
	private long channelFee;
	private String fundManangerFeeStr;
	private String channelFeeStr;
	
	List<SmartContract> smartContracts;
	List<FoundationFeeTrack> fees;
	
	public int getSmartContractLen() {
		if(!StringUtils.isEmpty(contracts)){
			return contracts.split(",").length;
		}
		return 0;
	}
	public void setSmartContractLen(int smartContractLen) {
		this.smartContractLen = smartContractLen;
	}
	public String getTotalStr() {
		if(0!=total){
    		return MoneyUtil.ccToMoneyFormat(total,"yuan");
    	}
		return "0";
	}
	public String getValidTotalStr() {
		if(0!=validTotal){
    		return MoneyUtil.ccToMoneyFormat(validTotal,"yuan");
    	}
		return "0";
	}
	public String getBalanceStr() {
		if(0!=balance){
    		return MoneyUtil.ccToMoneyFormat(balance,"yuan");
    	}
		return "0";
	}
	
	public String getFundManangerFeeStr() {
		if(0!=fundManangerFee){
    		return MoneyUtil.ccToMoneyFormat(fundManangerFee,"yuan");
    	}
		return "0";
	}
	
	public String getChannelFeeStr() {
		if(0!=channelFee){
    		return MoneyUtil.ccToMoneyFormat(channelFee,"yuan");
    	}
		return "0";
	}
	
	public long getFundManangerFee() {
		return fundManangerFee;
	}
	public void setFundManangerFee(long fundManangerFee) {
		this.fundManangerFee = fundManangerFee;
	}
	public long getChannelFee() {
		return channelFee;
	}
	public void setChannelFee(long channelFee) {
		this.channelFee = channelFee;
	}
	
	public void setFundManangerFeeStr(String fundManangerFeeStr) {
		this.fundManangerFeeStr = fundManangerFeeStr;
	}
	
	public void setChannelFeeStr(String channelFeeStr) {
		this.channelFeeStr = channelFeeStr;
	}
	public void setTotalStr(String totalStr) {
		this.totalStr = totalStr;
	}
	
	public void setValidTotalStr(String validTotalStr) {
		this.validTotalStr = validTotalStr;
	}
	
	public void setBalanceStr(String balanceStr) {
		this.balanceStr = balanceStr;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public List<SmartContract> getSmartContracts() {
		return smartContracts;
	}
	public void setSmartContracts(List<SmartContract> smartContracts) {
		this.smartContracts = smartContracts;
	}
	public List<FoundationFeeTrack> getFees() {
		return fees;
	}
	public void setFees(List<FoundationFeeTrack> fees) {
		this.fees = fees;
	}
	public String getContracts() {
		return contracts;
	}
	public void setContracts(String contracts) {
		this.contracts = contracts;
	}
	
	
}
