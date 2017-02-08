package com.ecloudtime.model;

import java.util.List;

public class ChainCodeInvokeRequest extends ChainCodeRequestModel{

	
	/*{
	    "jsonrpc": "2.0",
	    "method": "invoke",
	    "params": {
	    "type": 1,
	    "chaincodeID":{
	    "name":"3e0ff3192ad6b96324567aac390244cb585bc794fc38f6eaf921a2e4dc1c26fa03b4d87152208619fa2fe8223423a0a353a65704e4e4379d371b79275dbb5db5"
	    },
	    "ctorMsg": {
	    "function":"registerBank",
	    "args":["cebbank","LS0tLS1CRUdJTiBwdWJsaWMga2V5LS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FDK0oxWjRiTGFPOFNobTFyOXFOOHB6RjJxbwp1c08rSnhoOWpGcDdQTkcwMERGTUR5RUhWNU9JajhhdFlVdzBwRkFTUG95dldHMGhlRzdCVU00bVRpWHNZOFF3ClpYMjZ6L2I2bk05Q3ZtM2xlell1NjgwT2NQQnNIczdLb0RZTkUrUGM2c0EwRGVDVnUxNm5aeGpQbFRwbUxMdmkKb2Z3bS9ReVlKZlVsNElRazFRSURBUUFCCi0tLS0tRU5EIHB1YmxpYyBrZXktLS0tLQo=","TV1xznZQSfCliJBdTvKNhn5s1M8Ji9tuET68hrMQHpbd5LO83K7yHyMJQQo7lX4iV0qVvYyK5p8zeJwVVyOeNQd1jRpi83XmfLqWHzhddf3zK81xOpzz+2GVuZolyKS2dzXyheJ7holm3PyxUwZtL5+qWfQhAXBKLqN0LrU5pcE="]
	    },
	    "secureContext":  "jim"
	    },
	    "id": 3
	    }*/
	public ChainCodeInvokeRequest(String chaincodeName,String funcName,List<String> args){
		this.setJsonrpc("2.0");
		this.setMethod("invoke");
		this.setId(3);
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
}
