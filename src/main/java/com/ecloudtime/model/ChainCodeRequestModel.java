package com.ecloudtime.model;

import java.util.List;

public class ChainCodeRequestModel {

	private String jsonrpc;
	private String method;
	private ChainCodeRequestParams params;
	private int id;
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public String getJsonrpc() {
		return this.jsonrpc;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return this.method;
	}

	public void setParams(ChainCodeRequestParams params) {
		this.params = params;
	}

	public ChainCodeRequestParams getParams() {
		return this.params;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public class ChaincodeID {
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

		public ChaincodeID(String path,String name) {
			super();
			this.path=path;
			this.name = name;
		}
	}



	/*
	 * { "jsonrpc": "2.0", "method": "query", "params": { "type": 1,
	 * "chaincodeID":{ "name":
	 * "3e0ff3192ad6b96324567aac390244cb585bc794fc38f6eaf921a2e4dc1c26fa03b4d87152208619fa2fe8223423a0a353a65704e4e4379d371b79275dbb5db5"
	 * }, "ctorMsg": { "function":"queryBank", "args":[
	 * "cebbank:71266a9913375add341f1f7a4a606a2ee4e24efaf59bb2a3eb4b71aaaf5fb3fe"]
	 * }, "secureContext": "jim" }, "id": 5 }
	 */
}
