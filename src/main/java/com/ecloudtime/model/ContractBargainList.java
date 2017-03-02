package com.ecloudtime.model;

import java.util.List;

public class ContractBargainList {
	private SmartContractExt smartContractExt;
	private List<ContractBargain> contractBargainList;

	public SmartContractExt getSmartContractExt() {
		return smartContractExt;
	}
	public void setSmartContractExt(SmartContractExt smartContractExt) {
		this.smartContractExt = smartContractExt;
	}
	public List<ContractBargain> getContractBargainList() {
		return contractBargainList;
	}
	public void setContractBargainList(List<ContractBargain> contractBargainList) {
		this.contractBargainList = contractBargainList;
	}
	
}
