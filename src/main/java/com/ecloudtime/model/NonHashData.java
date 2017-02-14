package com.ecloudtime.model;

import java.util.List;

public class NonHashData implements java.io.Serializable{
	private static final long serialVersionUID = -1943961352036134112L;
	
	private LocalLedgerCommitTimestamp localLedgerCommitTimestamp;

	private List<ChaincodeEvent> chaincodeEvents;

	public void setLocalLedgerCommitTimestamp(LocalLedgerCommitTimestamp localLedgerCommitTimestamp) {
		this.localLedgerCommitTimestamp = localLedgerCommitTimestamp;
	}

	public LocalLedgerCommitTimestamp getLocalLedgerCommitTimestamp() {
		return this.localLedgerCommitTimestamp;
	}

	public void setChaincodeEvents(List<ChaincodeEvent> chaincodeEvents) {
		this.chaincodeEvents = chaincodeEvents;
	}

	public List<ChaincodeEvent> getChaincodeEvents() {
		return this.chaincodeEvents;
	}

}