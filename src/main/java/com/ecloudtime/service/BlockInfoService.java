package com.ecloudtime.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecloudtime.model.BlockHighGen;
import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.ChaincodeEvent;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.utils.HttpRequestUtils;

import net.sf.json.JSONObject;

@Service
public class BlockInfoService {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

	@Autowired
	private HttpService httpService;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Value("${chaincode.base.nodeUrl}")
	private String nodeUrl;
	
	
	@Value("${chaincode.base.newerListNumber}")
	private int newerListNumber;
	
	/**
	 * {
		  "height": 8,
		  "currentBlockHash": "BLGW/rRsmLvl1H6jTHaO8tRjaz1iaxeFG5kV0C3IXuqYv+4Dgaoml6Q+kbDPx0tY2JBcY25E1sb/0T+K2B/86Q==",
		  "previousBlockHash": "Eo2bVp51syIeXBHYC2/73gUjJ/43wwg9RNl+U65diKWOitaY2zLAxayFAeDzEriC3nuohiXY4gk72rsiNArnQw=="
		}
	 * @param url   http://192.168.31.100:7050/chain
	 * @return
	 */
	public JSONObject queryCurrentPeerStatus(String url){
		JSONObject jsonObject= httpService.httpGet(url);
		return jsonObject;
	}
	
	public JSONObject queryCurrentPeerStatus(){
		JSONObject jsonObject= httpService.httpGet(nodeUrl+"/chain");
		return jsonObject;
	}
	
	
	public BlockInfo queryBlockByHigh(int height){
		
		return queryBlockByHigh(nodeUrl+"/chain/blocks/"+height);
	}
	
	/**
	 * 根据当前高度查询区块信息
	 * @param url
	 * @return
	 */
	public BlockInfo queryBlockByHigh(String url){
		JSONObject jsonObject= httpService.httpGet(url);
		if(null!=jsonObject){
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("chaincodeEvents", ChaincodeEvent.class);
			classMap.put("transactions", Transaction.class);
			BlockInfo block=(BlockInfo)JSONObject.toBean(jsonObject, BlockInfo.class,classMap);
			return block;
		}
		return null;
	}
	
	/**
	 * 
	 * @param txId
	 * 192.168.31.100:7050/transactions/28634a38-f6f7-4c36-88d7-3b7612f30749
	 * @return
	 */
	public Transaction queryTransactionByTxId(String txId){
		JSONObject jsonObject= httpService.httpGet(nodeUrl+"/transactions/"+txId);
		Transaction transaction=(Transaction)JSONObject.toBean(jsonObject, Transaction.class);
		return transaction;
	}
	
	
	
	public int getCurrentHigh(){
		return getCurrentHigh(nodeUrl+"/chain");
	}
	
	//获取区块的当前高度
	public int getCurrentHigh(String url){
		JSONObject jsonObject=queryCurrentPeerStatus(url);
		if(null!=jsonObject){
			return jsonObject.getInt("height");
		}
		return 0;
	}
	
	/**
	 * 获取最新的几个区块链 交易
	 * 1.获取最新的区块高度
	 * @return
	 */
	public List<Transaction> getNewerTransactions(){
		List<BlockInfo> blockInfoList=getNewerBlocks();
		List<Transaction> transList =this.cacheManager.getCacheTransInfoList();
		if(null==transList||transList.size()==0){
			for(BlockInfo blockInfo :blockInfoList){
				if(null==blockInfo||null==blockInfo.getTransactions()) continue;
				if(transList.size()>newerListNumber){
					break;
				}
				transList.addAll(blockInfo.getTransactions());
			}
		}
		return transList;
	}
	
	
	public List<BlockHighGen> getNewerBolckHighTimes(){
		List<BlockHighGen> blockHighList = (List<BlockHighGen>)this.cacheManager.getCacheObjectByKey("blockHighList");
		if(null==blockHighList){
			getNewerBlocks();
		}
		if(null!=blockHighList&&blockHighList.size()>0){
			BlockHighGen blockHighGen=(BlockHighGen)blockHighList.get(0);
			int cacheHigh=blockHighGen.getBlockHigh();
//			cacheHigh=25;
			int currentHigh=this.getCurrentHigh();
			String url=nodeUrl+"/chain/blocks/";//http://192.168.31.100:7050/chain/blocks/7
			
			while(cacheHigh<currentHigh){
				cacheHigh++;
				BlockHighGen blockHigh=new BlockHighGen(cacheHigh);
				BlockInfo blockInfo =queryBlockByHigh(url+cacheHigh);
				if(null!=blockInfo){
					blockHigh.setBlockGenTime(blockInfo.getBlockGenTime());
					if(blockHighList.size()>newerListNumber){
						blockHighList.remove(blockHighList.size()-1);
					}
					blockHighList.add(0, blockHigh);
				}
			}
			this.cacheManager.putObjectToCache("blockHighList", blockHighList);
		}
		
//		blockHighList= (List<BlockHighGen>)this.cacheManager.getCacheObjectByKey("blockHighList");
		return blockHighList;
	}
	
	/**
	 * 获取最新的区块情况
	 * @param number
	 * @return
	 */
	public List<BlockInfo> getNewerBlocks(){
		List<BlockInfo> blockInfoList = (List<BlockInfo>)this.cacheManager.getCacheObjectByKey("blockInfoList");
		List<BlockHighGen> blockHighList = (List<BlockHighGen>)this.cacheManager.getCacheObjectByKey("blockHighList");
		if(null==blockInfoList)blockInfoList=new ArrayList<BlockInfo>();
		if(null==blockHighList)blockHighList=new ArrayList<BlockHighGen>();
		String url=nodeUrl+"/chain";
		int currentHigh=getCurrentHigh(url);
		int cacheHigh=this.cacheManager.getCacheBlockHigh();
		url=nodeUrl+"/chain/blocks/";//http://192.168.31.100:7050/chain/blocks/7
		boolean flag=false;
		while(currentHigh>cacheHigh||blockHighList.size()<=newerListNumber){
			if(!flag){
				flag=true;
				this.cacheManager.putBlockHighToCache(currentHigh);
			}
			BlockHighGen blockHigh=new BlockHighGen(currentHigh);
			currentHigh--;
			BlockInfo blockInfo =queryBlockByHigh(url+currentHigh);
			if(blockInfoList.size()>newerListNumber||null==blockInfo){
				blockInfoList.remove(blockInfoList.size()-1);
				blockInfoList.add(blockInfo);
				blockHigh.setBlockGenTime(blockInfo.getBlockGenTime());
				blockHighList.add(blockHigh);
				break;
			}else{
				blockInfoList.add(blockInfo);
				blockHigh.setBlockGenTime(blockInfo.getBlockGenTime());
				blockHighList.add(blockHigh);
			}
		}
		if(flag){
			this.cacheManager.putBlcokInfoListToCache(blockInfoList);
			this.cacheManager.putObjectToCache("blockHighList", blockHighList);
		}
		
		return blockInfoList;
	}
	
	public static void main(String[] args) {
		List list = new ArrayList();
		for(int i=0 ;i<10 ;i++){
			list.add(i);
		}
		for(int i=0 ;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
}
