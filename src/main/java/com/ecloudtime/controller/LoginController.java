package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.DonorContribution;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
    private ApiService apiService;
	
	
	@RequestMapping("/login")
	@ApiOperation(value="login",notes="requires login Name")
	public String login(@RequestParam(value = "name", required = false, defaultValue = "name") String name,
			Model model) {
		model.addAttribute("name", name);
		return "login";
	}
	
	@RequestMapping("/index")
	@ApiOperation(value="index",notes="requires login Name default user01")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "donor01") String name,
			Model model) {
		model.addAttribute("name", name);
		User user =apiService.queryDonor(name);
		if(null==user.getName())user.setName("donor01");
		model.addAttribute("user", user);
		name="smartcontract01";
		List<SmartContract> smartcontracts= apiService.queryTreaties(name);
		model.addAttribute("smartcontracts", smartcontracts);
		return "index";
	}
	
	@RequestMapping("/mine_gift")
	@ApiOperation(value="mine_gift",notes="requires login Name")
	public String mine_gift(@RequestParam(value = "name", required = false, defaultValue = "donor01") String name,
			Model model) {
		model.addAttribute("name", name);
		User user =apiService.queryDonor(name);
		List<DonorContribution> donorHisList=user.getContributions();
		model.addAttribute("donorHisList", donorHisList);
		return "mine_gift";
	}

}