package com.ecloudtime.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.Transaction;

@Service
public class CacheManager {
	protected Logger logger = Logger.getLogger(this.getClass());
	
	private Map cacheData = new ConcurrentHashMap();
	
	public Object getCacheObjectByKey(String key){
		if(cacheData.containsKey(key)){
			return cacheData.get(key);
		}
		return null;
	}
	
	public void putObjectToCache(String key ,Object value){
		cacheData.put(key, value);
	}
	
	/********************************获取区块信息list******************************************************/
	public List<BlockInfo>  getCacheBlcokInfoList(){
		List<BlockInfo> blockInfoList = (List<BlockInfo>)getCacheObjectByKey("blockInfoList");
		if(null==blockInfoList){
			blockInfoList=new ArrayList<BlockInfo>();	
		}
		return blockInfoList;
	}
	
	public void putBlcokInfoListToCache(List<BlockInfo> blockInfoList){
		cacheData.put("blockInfoList", blockInfoList);
	}
	
	public void clearBlcokInfoListFromCache(){
		cacheData.remove("blockInfoList");
	}
	/********************************获取交易信息list******************************************************/
	public List<Transaction>  getCacheTransInfoList(){
		List<Transaction> transInfoList = (List<Transaction>)getCacheObjectByKey("transInfoList");
		if(null==transInfoList){
			transInfoList=new ArrayList<Transaction>();	
		}
		return transInfoList;
	}
	
	public void putTransInfoListToCache(List<Transaction> transInfoList){
		cacheData.put("transInfoList", transInfoList);
	}
	
	public void clearTransInfoListFromCache(){
		cacheData.remove("transInfoList");
	}
	/********************************获取交易信息list******************************************************/
	public int getCacheBlockHigh(){
		Integer cacheHigh=(Integer)getCacheObjectByKey("cacheHigh");
		if(null==cacheHigh)cacheHigh=-1;
		return cacheHigh;
	}
	
	public void putBlockHighToCache(int cacheHigh){
		this.putObjectToCache("cacheHigh", cacheHigh);
	}
	
}
