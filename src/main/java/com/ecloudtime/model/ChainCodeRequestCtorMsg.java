package com.ecloudtime.model;

import java.util.List;

public class ChainCodeRequestCtorMsg {

	private String function;
	private List<String> args;
	public void setFunction(String function) {
		this.function = function;
	}

	public String getFunction() {
		return this.function;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}



}
