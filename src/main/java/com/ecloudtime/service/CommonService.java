package com.ecloudtime.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecloudtime.mapper.CommonMapper;
import com.ecloudtime.model.Bargain;
import com.ecloudtime.model.ContractBargain;
import com.ecloudtime.model.Foundation;
import com.ecloudtime.model.FundFlow;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SysDonorDrawTransRel;
import com.ecloudtime.model.TransDetail;

@Service
public class CommonService {

	 private static Logger logger = LoggerFactory.getLogger(CommonService.class); // 日志记录
	
	 @Autowired
	 private CommonMapper commonMapper;
	 
	 public String getDonorUuid(){
		 
		 return UUID.randomUUID().toString();
	 }
	 public void saveTxidDonorDrawIdRefInfo(SysDonorDrawTransRel donorRel){
		 commonMapper.saveTxidDonorDrawIdRefInfo(donorRel);
	 }
	 public void saveFundFlowInfo(FundFlow fundFlow){
		 commonMapper.saveFundFlowInfo(fundFlow);
	 }
	 
	 public SysDonorDrawTransRel findDonorTransRelByDonorid(String donorid){
		 return (SysDonorDrawTransRel)this.commonMapper.findDonorTransRelByDonorid(donorid);
	 }
	 
	public SysDonorDrawTransRel findDonorTransRelByTxid(String txid){
		return (SysDonorDrawTransRel)this.commonMapper.findDonorTransRelByTxid(txid);
	}
	 
	 /**
	  * 
	  * @param name
	  * @return
	  */
	 public String findDonorAddrById(String name){
		 
		 return (String)this.commonMapper.findDonorAddrById(name);
	 } 
	 public String findSmartContractAddrById(String name){
		 
		 return (String)this.commonMapper.findSmartContractAddrById(name);
	 } 
	 
	 public String findBargainAddrById(String name){
		 
		 return (String)this.commonMapper.findBargainAddrById(name);
	 } 
	 
	 public SmartContract findContractInfo(SmartContract contract)//查询合约信息
	 {
		 return commonMapper.findContractInfo(contract);
	 }
	 
	 
	 public List<SmartContract> findContractInfoList(){
		 List<SmartContract> list=commonMapper.findContractInfoList();
		 return list;
	 }//查询合约信息
	 
	 public String findAllSmartContractS(){
		 List<SmartContract> list=findContractInfoList();
		 StringBuffer sb = new StringBuffer();
		 for(SmartContract smc :list){
			 sb.append(smc.getAddr());
			 sb.append(",");
		 }
		 sb.delete(sb.length()-1, sb.length());
		 return sb.toString();
	 }
	 
	 public String findAllBargainS(){
		 List<Bargain> list=findBargainList();
		 StringBuffer sb = new StringBuffer();
		 for(Bargain bg :list){
			 sb.append(bg.getAddr());
			 sb.append(",");
		 }
		 sb.delete(sb.length()-1, sb.length());
		 return sb.toString();
	 }
	 
	 public List<Bargain> findBargainList(){
		 return commonMapper.findBargainList();
	 }//查询合约信息
	 
	 public int findBargainLen(){
		 List<Bargain> list=findBargainList();
		 return list.size();
	 }
	 
	 
	 
	 public Foundation findFoundByAddr(String foundId){
		 return this.commonMapper.findFoundByAddr(foundId);
	 }
	 
	 public List<TransDetail> queryTransDetailsList(TransDetail transDetail){
		 return this.commonMapper.queryTransDetailsList(transDetail);
	 }
	 public List<ContractBargain> findContractBargainList(String smartContractId){
		 ContractBargain contractBargain = new ContractBargain();
		 contractBargain.setSmartContractId(smartContractId);
		 return findContractBargainList(contractBargain);
	 }
	 public List<ContractBargain> findContractBargainList(ContractBargain contractBargain){
		 return this.commonMapper.findContractBargainList(contractBargain);
	 }
	 
	 public static void main(String[] args) {
		 CommonService cm = new CommonService();
		 System.out.println(cm.getDonorUuid());
	}
}

