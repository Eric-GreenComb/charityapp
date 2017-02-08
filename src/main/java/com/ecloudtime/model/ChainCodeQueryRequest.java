package com.ecloudtime.model;

import java.util.List;

public class ChainCodeQueryRequest extends ChainCodeRequestModel {

	/* {
		    "jsonrpc": "2.0",
		    "method": "query",
		    "params": {
		    "type": 1,
		    "chaincodeID":{
		    "name":"8b9ccebd1587fbf83da1a7a01b0383c967cec84f0515d04b88f9055a04e35c720c927948ddfc6af8647f4ba60c46edae27f51e543e652fe7126e4281fb053838"
		    },
		    "ctorMsg": {
		    "function":"queryBank",
		    "args":["cebbank:71266a9913375add341f1f7a4a606a2ee4e24efaf59bb2a3eb4b71aaaf5fb3fe"]
		    },
		    "secureContext":  "jim"
		    },
		    "id": 5
		    }*/
	
	public ChainCodeQueryRequest(String chaincodeName,String funcName,List<String> args) {
		this.setJsonrpc("2.0");
		this.setMethod("query");
		this.setId(5);
		ChainCodeRequestParams params=new ChainCodeRequestParams();
		params.setType(1);
		params.setChaincodeID(new ChainCodeRequestChainCodeId("",chaincodeName));
		ChainCodeRequestCtorMsg ctorMsg=new ChainCodeRequestCtorMsg();
		ctorMsg.setFunction(funcName);
		ctorMsg.setArgs(args);
		params.setCtorMsg(ctorMsg);
		params.setSecureContext("jim");
		this.setParams(params);
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
