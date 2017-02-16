package com.ecloudtime.model;

public class BargainGo {
/*
	Addr        string        `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"`
	Id          string        `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"`
	Name        string        `protobuf:"bytes,3,opt,name=name" json:"name,omitempty"`
	Detail      string        `protobuf:"bytes,4,opt,name=detail" json:"detail,omitempty"`
	StartTime   string        `protobuf:"bytes,5,opt,name=startTime" json:"startTime,omitempty"`
	EndTime     string        `protobuf:"bytes,6,opt,name=endTime" json:"endTime,omitempty"`
	PartyA      string        `protobuf:"bytes,7,opt,name=partyA" json:"partyA,omitempty"`
	PartyB      string        `protobuf:"bytes,8,opt,name=partyB" json:"partyB,omitempty"`
	DepositBank string        `protobuf:"bytes,9,opt,name=depositBank" json:"depositBank,omitempty"`
	BankAccount string        `protobuf:"bytes,10,opt,name=bankAccount" json:"bankAccount,omitempty"`
	AttachFiles []*AttachFile `protobuf:"bytes,11,rep,name=attachFiles" json:"attachFiles,omitempty"`
	Status      int64         `protobuf:"varint,12,opt,name=status" json:"status,omitempty"`
	Remark      string        `protobuf:"bytes,13,opt,name=remark" json:"remark,omitempty"`*/
	
	private String addr;
	private String id;
	private String name;
	private String detail;
	private String startTime;
	private String endTime;
	private String partyA;
	private String partyB;
	private String depositBank;
	private String bankAccount;
	private int status;
	private String remark;
	private String attach;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPartyA() {
		return partyA;
	}
	public void setPartyA(String partyA) {
		this.partyA = partyA;
	}
	public String getPartyB() {
		return partyB;
	}
	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}
	public String getDepositBank() {
		return depositBank;
	}
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	
	
}
