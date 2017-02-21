package com.ecloudtime.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecloudtime.mapper.CommonMapper;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SysDonorTransRel;

@Service
public class CommonService {

	 private static Logger logger = LoggerFactory.getLogger(CommonService.class); // 日志记录
	
	 @Autowired
	 private CommonMapper commonMapper;
	 
	 public String getDonorUuid(){
		 
		 return UUID.randomUUID().toString();
	 }
	 public void saveTxidDonorIdRefInfo(SysDonorTransRel donorRel){
		 commonMapper.saveTxidDonorIdRefInfo(donorRel);
	 }
	 
	 public SysDonorTransRel findDonorTransRelByDonorid(String donorid){
		 return (SysDonorTransRel)this.commonMapper.findDonorTransRelByDonorid(donorid);
	 }
	 
	public SysDonorTransRel findDonorTransRelByTxid(String txid){
		return (SysDonorTransRel)this.commonMapper.findDonorTransRelByTxid(txid);
	}
	 
	 /**
	  * 
	  * @param name
	  * @return
	  */
	 public String findDonorAddrByName(String name){
		 
		 return (String)this.commonMapper.findDonorAddrByName(name);
	 } 
	 public String findSmartContractAddrByName(String name){
		 
		 return (String)this.commonMapper.findSmartContractAddrByName(name);
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
	 
	 public static void main(String[] args) {
		 CommonService cm = new CommonService();
		 System.out.println(cm.getDonorUuid());
	}
}
