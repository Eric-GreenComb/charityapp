package com.ecloudtime.mapper;

import java.util.List;

import com.ecloudtime.model.Bargain;
import com.ecloudtime.model.Foundation;
import com.ecloudtime.model.FundFlow;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SysDonorDrawTransRel;
import com.ecloudtime.model.TransDetail;

public interface CommonMapper {

	public SmartContract findContractInfo(SmartContract contract);//查询合约信息
	public List<SmartContract> findContractInfoList();//查询合约信息
	public List<Bargain> findBargainList();//查询合同信息
	
	public Bargain findBargainInfo();//查询合同信息
	
	public String findDonorAddrById(String name);//根据名称 查询addr
	
	public String findSmartContractAddrById(String name);//根据名称 查询addr
	
	public void saveTxidDonorDrawIdRefInfo(SysDonorDrawTransRel donorRel);//保存存储捐款id和cc中txid的对应关系
	
	 public void saveFundFlowInfo(FundFlow fundFlow);//保存基金流水信息表
	
	public SysDonorDrawTransRel findDonorTransRelByDonorid(String donorid);//查询捐款id和业务id对应关系
	public SysDonorDrawTransRel findDonorTransRelByTxid(String txid);//查询捐款id和业务id对应关系
	
	
	public Foundation findFoundByAddr(String foundId);
	
	public List<TransDetail> findTransDetailsList(TransDetail transDetail);
//	public Bargain findBargainInfo();//查询合同信息
	
	
}
