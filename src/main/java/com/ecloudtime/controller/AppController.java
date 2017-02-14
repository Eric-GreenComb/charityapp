package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.BlockHighGen;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.HttpService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/app")
public class AppController extends BaseController{


    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;
    
    @RequestMapping("/index")
   	@ApiOperation(value="index",notes="requires login Name default user01")
   	public String index(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
   			Model model) {
   		model.addAttribute("name", name);
   		return "app/index";
   	}
}
