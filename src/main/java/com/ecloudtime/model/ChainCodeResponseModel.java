package com.ecloudtime.model;

public class ChainCodeResponseModel {

	private String jsonrpc;

	private ChainCodeResponseResult result;

	private int id;

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public String getJsonrpc() {
		return this.jsonrpc;
	}

	public void setResult(ChainCodeResponseResult result) {
		this.result = result;
	}

	public ChainCodeResponseResult getResult() {
		return this.result;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public ChainCodeResponseModel() {
		// TODO Auto-generated constructor stub
	}

}
