package com.ecloudtime.mapper;

import java.util.List;

import com.ecloudtime.model.Bargain;
import com.ecloudtime.model.SmartContract;

public interface CommonMapper {

	public SmartContract findContractInfo(SmartContract contract);//查询合约信息
	public List<SmartContract> findContractInfoList();//查询合约信息
	
	public Bargain findBargainInfo();//查询合同信息
	
	public String findDonorAddrByName(String name);//根据名称 查询addr
	
	public String findSmartContractAddrByName(String name);//根据名称 查询addr
	
//	public Bargain findBargainInfo();//查询合同信息
	
	
}
