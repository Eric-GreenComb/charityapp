package com.ecloudtime.model;

import java.util.List;

public class TX {
	private long version;
	private long timestamp;
	private String inputData;//这个原型 go中是 name=inputData" json:"InputData,omitempty  有可能会出现问题
	private String founder;
	private List<TX_TXIN> txin;
	private List<TX_TXOUT> txout;
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getInputData() {
		return inputData;
	}
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public List<TX_TXIN> getTxin() {
		return txin;
	}
	public void setTxin(List<TX_TXIN> txin) {
		this.txin = txin;
	}
	public List<TX_TXOUT> getTxout() {
		return txout;
	}
	public void setTxout(List<TX_TXOUT> txout) {
		this.txout = txout;
	}
	
	/*Version   uint64      `protobuf:"varint,1,opt,name=version" json:"version,omitempty"`
	Timestamp int64       `protobuf:"varint,2,opt,name=timestamp" json:"timestamp,omitempty"`
	Txin      []*TX_TXIN  `protobuf:"bytes,3,rep,name=txin" json:"txin,omitempty"`
	Txout     []*TX_TXOUT `protobuf:"bytes,4,rep,name=txout" json:"txout,omitempty"`
	InputData string      `protobuf:"bytes,5,opt,name=InputData" json:"InputData,omitempty"`
	Founder   string      `protobuf:"bytes,6,opt,name=founder" json:"founder,omitempty"`*/
}
