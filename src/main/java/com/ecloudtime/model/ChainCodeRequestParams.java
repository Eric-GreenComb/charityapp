package com.ecloudtime.model;

public class ChainCodeRequestParams {

	private int type;

	private ChainCodeRequestChainCodeId chaincodeID;

	private ChainCodeRequestCtorMsg ctorMsg;

	private String secureContext;

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setChaincodeID(ChainCodeRequestChainCodeId chaincodeID) {
		this.chaincodeID = chaincodeID;
	}

	public ChainCodeRequestChainCodeId getChaincodeID() {
		return this.chaincodeID;
	}

	public void setCtorMsg(ChainCodeRequestCtorMsg ctorMsg) {
		this.ctorMsg = ctorMsg;
	}

	public ChainCodeRequestCtorMsg getCtorMsg() {
		return this.ctorMsg;
	}

	public void setSecureContext(String secureContext) {
		this.secureContext = secureContext;
	}

	public String getSecureContext() {
		return this.secureContext;
	}


}
