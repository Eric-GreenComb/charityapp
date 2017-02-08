package com.ecloudtime.model;

import java.util.ArrayList;

import com.ecloudtime.model.ChainCodeRequestModel.ChaincodeID;

public class ChainCodeDeployRequest extends ChainCodeRequestModel{

	/*
	 {
	      "jsonrpc": "2.0",
	      "method": "deploy",
	      "params": {
	        "type": 1,
	        "chaincodeID":{
	          "path": "github.com/CebEcloudTime/charitycc"
	        },
	        "ctorMsg": {
	          "function":"deploy",
	          "args":[]
	        }
	      },
	      "id": 1
	    }*/
	public ChainCodeDeployRequest(String path) {
		super();
		this.setId(1);
		this.setJsonrpc("2.0");
		this.setMethod("deploy");
		ChainCodeRequestParams params=new ChainCodeRequestParams();
		params.setType(1);
		this.setParams(params);
		params.setChaincodeID(new ChainCodeRequestChainCodeId(path,""));
		ChainCodeRequestCtorMsg ctorMsg=new ChainCodeRequestCtorMsg();
		ctorMsg.setFunction("deploy");
		ctorMsg.setArgs(new ArrayList<String>());
		params.setCtorMsg(ctorMsg);
		this.setParams(params);
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
