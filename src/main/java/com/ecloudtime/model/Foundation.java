package com.ecloudtime.model;

import java.util.List;

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
	private String contract;
	private String name;
	private String id;
	private long total;
	private long validTotal;
	private long balance;
	List<SmartContract> smartContracts;
	List<FoundationFeeTrack> fees;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
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
	
	
}
