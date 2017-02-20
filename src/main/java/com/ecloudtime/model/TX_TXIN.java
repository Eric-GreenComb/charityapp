package com.ecloudtime.model;

public class TX_TXIN {

	private  int idx;
	private  String sourceTxHash;
	private  String addr;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSourceTxHash() {
		return sourceTxHash;
	}
	public void setSourceTxHash(String sourceTxHash) {
		this.sourceTxHash = sourceTxHash;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/*
	Idx          uint32 `protobuf:"varint,1,opt,name=idx" json:"idx,omitempty"`
	SourceTxHash string `protobuf:"bytes,2,opt,name=sourceTxHash" json:"sourceTxHash,omitempty"`
	// indicate owner's addr
	Addr string `protobuf:"bytes,3,opt,name=addr" json:"addr,omitempty"`*/
}
