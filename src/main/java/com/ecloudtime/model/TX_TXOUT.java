package com.ecloudtime.model;

public class TX_TXOUT {

	private long value;
	private String addr;
	private String attr;
	private String sign;
	
	
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	/*Value uint64 `protobuf:"varint,1,opt,name=value" json:"value,omitempty"`
	Addr  string `protobuf:"bytes,2,opt,name=addr" json:"addr,omitempty"`
	Attr  string `protobuf:"bytes,3,opt,name=attr" json:"attr,omitempty"`
	Sign  string `protobuf:"bytes,4,opt,name=sign" json:"sign,omitempty"`*/
}
