package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.SessionUtils;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/merchant")
public class MerchantController extends BaseController{

	@Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;
    
    @RequestMapping("login")
   	@ApiOperation(value="login",notes="requires login Name default user01")
   	public String login(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
   			Model model) {
    	model.addAttribute("name", name);
//		User user =apiService.queryDonor(name);
		User user =SessionUtils.getUserFromSession();
		if(null==user.getName())user.setName("donor01");
		model.addAttribute("user", user);
		name="smartcontract01";
		List<SmartContract> smartcontracts= apiService.querySmartContracts(name);
		model.addAttribute("smartcontracts", smartcontracts);
		return "login";
   	}
    
    @RequestMapping("index")
   	@ApiOperation(value="index",notes="requires login Name default user01")
   	public String index(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
   			Model model) {
    	model.addAttribute("name", name);
//		User user =apiService.queryDonor(name);
		User user =SessionUtils.getUserFromSession();
		if(null==user.getName())user.setName("donor01");
		model.addAttribute("user", user);
		name="smartcontract01";
		List<SmartContract> smartcontracts= apiService.querySmartContracts(name);
		model.addAttribute("smartcontracts", smartcontracts);
		return "index";
   	}
}
