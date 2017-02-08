package com.ecloudtime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String index(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
			Model model) {
		model.addAttribute("name", name);
		User user =apiService.queryDonor(name);
		model.addAttribute("userName", "1352****9849");
		model.addAttribute("user", user);
		
		return "index";
	}

}