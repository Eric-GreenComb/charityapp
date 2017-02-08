package com.ecloudtime.model;

public class Channel {

	/*Addr  string             `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"`
	Id    string             `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"`
	Name  string             `protobuf:"bytes,3,opt,name=name" json:"name,omitempty"`
	Total uint64             `protobuf:"varint,4,opt,name=total" json:"total,omitempty"`
	Fees  []*ChannelFeeTrack `protobuf:"bytes,5,rep,name=fees" json:"fees,omitempty"`*/

	private String addr;
	private String id;
	private String name;
	private int total;
	
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
