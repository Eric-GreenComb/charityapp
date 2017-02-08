package com.ecloudtime.model;

public class ChainCodeRequestChainCodeId {


	private String name;
	private String path;
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ChainCodeRequestChainCodeId(String path,String name) {
		super();
		this.path=path;
		this.name = name;
	}

	
}
