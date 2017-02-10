package com.ecloudtime.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

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
	
}
