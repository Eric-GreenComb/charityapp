package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.CacheManager;
import com.wordnik.swagger.annotations.ApiOperation;

public class DonateController extends BaseController{

	@Autowired
    private ApiService apiService;
	@Autowired
	private CacheManager cacheManager;
	
	@RequestMapping("/myDonateHis")
	@ApiOperation(value="myDonateHis",notes="myDonateHis")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
			Model model) {
		model.addAttribute("name", name);
		
		User user =apiService.queryDonor(name);
		model.addAttribute("user", user);
		name="treaty01";
		List<SmartContract> treatys= apiService.queryTreaties(name);
		model.addAttribute("treatys", treatys);
		return "index";
	}
}
