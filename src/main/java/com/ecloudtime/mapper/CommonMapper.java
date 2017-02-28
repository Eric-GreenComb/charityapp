package com.ecloudtime.mapper;

import java.util.List;

import com.ecloudtime.model.Bargain;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SysDonorDrawTransRel;

public interface CommonMapper {

	public SmartContract findContractInfo(SmartContract contract);//查询合约信息
	public List<SmartContract> findContractInfoList();//查询合约信息
	
	public Bargain findBargainInfo();//查询合同信息
	
	public String findDonorAddrById(String name);//根据名称 查询addr
	
	public String findSmartContractAddrById(String name);//根据名称 查询addr
	
	public void saveTxidDonorDrawIdRefInfo(SysDonorDrawTransRel donorRel);
	
	public SysDonorDrawTransRel findDonorTransRelByDonorid(String donorid);
	public SysDonorDrawTransRel findDonorTransRelByTxid(String txid);
	
//	public Bargain findBargainInfo();//查询合同信息
	
	
}
