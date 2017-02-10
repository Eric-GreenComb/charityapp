package com.ecloudtime.model;

public class ChannelFeeTrack {
/*
	Name      string `protobuf:"bytes,1,opt,name=name" json:"name,omitempty"`
	Amount    uint64 `protobuf:"varint,2,opt,name=amount" json:"amount,omitempty"`
	Timestamp int64  `protobuf:"varint,3,opt,name=timestamp" json:"timestamp,omitempty"`*/
	
	private String name;
	private long amount;
	private int timestamp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
