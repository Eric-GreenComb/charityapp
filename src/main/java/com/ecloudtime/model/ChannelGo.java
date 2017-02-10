package com.ecloudtime.model;

import java.util.List;

public class ChannelGo {

	/*
	 * Addr string `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"` Id
	 * string `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"` Name string
	 * `protobuf:"bytes,3,opt,name=name" json:"name,omitempty"` Total uint64
	 * `protobuf:"varint,4,opt,name=total" json:"total,omitempty"` Fees
	 * []*ChannelFeeTrack `protobuf:"bytes,5,rep,name=fees"
	 * json:"fees,omitempty"`
	 */

	private String addr;
	private String id;
	private String name;
	private long total;
	private List<ChannelFeeTrack> fees;

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

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<ChannelFeeTrack> getFees() {
		return fees;
	}

	public void setFees(List<ChannelFeeTrack> fees) {
		this.fees = fees;
	}

}
