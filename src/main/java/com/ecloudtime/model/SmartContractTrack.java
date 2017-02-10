package com.ecloudtime.model;

import java.util.List;

public class SmartContractTrack {
	
	private String addr;
	private String id;
	private long total;
	private long validTotal;
	private long donateNumber;
	List<SmartContractHistory> trans;

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
	public List<SmartContractHistory> getTrans() {
		return trans;
	}
	public void setTrans(List<SmartContractHistory> trans) {
		this.trans = trans;
	}
	
	
	
	
/*
	Addr         string                  `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"`
	Id           string                  `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"`
	Total        uint64                  `protobuf:"varint,3,opt,name=total" json:"total,omitempty"`
	ValidTotal   uint64                  `protobuf:"varint,4,opt,name=validTotal" json:"validTotal,omitempty"`
	DonateNumber uint64                  `protobuf:"varint,5,opt,name=donateNumber" json:"donateNumber,omitempty"`
	Trans        []*SmartContractHistory `protobuf:"bytes,6,rep,name=trans" json:"trans,omitempty"`*/
}
