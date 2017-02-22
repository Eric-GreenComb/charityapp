package com.ecloudtime.model;

import java.util.List;

public class SmartContractTrack {
	private String addr;
	List<SmartContractHistory> trans;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<SmartContractHistory> getTrans() {
		return trans;
	}
	public void setTrans(List<SmartContractHistory> trans) {
		this.trans = trans;
	}
	
	/*
	Addr  string                  `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"`
	Trans []*SmartContractHistory `protobuf:"bytes,2,rep,name=trans" json:"trans,omitempty"`*/
	
}
