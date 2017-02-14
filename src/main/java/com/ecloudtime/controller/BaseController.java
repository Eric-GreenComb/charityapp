package com.ecloudtime.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ecloudtime.utils.HttpRequestUtils;

public class BaseController {
	
	public static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //日志记录
	
	@Value("${server.context-path}")
	private String systemBasePath;

	@ModelAttribute("system")  
    public Map addBaseSystemParam() {  
//        logger.info("Inside of addBaseSystemParam");
        Map<String,String> params = new HashMap<String,String>();
        params.put("basePath", systemBasePath);
        return params;  
    }  
	
	public BaseController() {
		// TODO Auto-generated constructor stub
	}

}
