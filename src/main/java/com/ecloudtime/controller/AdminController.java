package com.ecloudtime.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecloudtime.model.DonorContribution;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.SessionUtils;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/admin")
public class AdminController extends BaseController{
	
    @Autowired
    private HttpService httpService;
    
    @Autowired
	private CommonService commonService;
    
    @Autowired
    private BlockInfoService blockInfoService;
    
    @Autowired
	private CacheManager cacheManager;
    
    @Autowired
    private ApiService apiService;
    
    
    @RequestMapping("/login")
	@ApiOperation(value="login",notes="requires login Name")
	public String login(Model model) {
//		name="donor01";
		String userName=SessionUtils.getUserNameFromSession();
		
		return "admin/login";
	}
}
