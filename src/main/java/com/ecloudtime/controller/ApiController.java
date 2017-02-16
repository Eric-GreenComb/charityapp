package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.Contract;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.HttpService;
import com.wordnik.swagger.annotations.ApiOperation;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="/apicc")
public class ApiController extends BaseController{

    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;
    
    @Autowired
    private BlockInfoService blockInfoService;
    
    
    
    
	@ApiOperation(value="queryBank",notes="requires noting")
    @RequestMapping(value="/queryBank",method=RequestMethod.GET)
    public Contract queryBank(@RequestParam(value="name", required=false, defaultValue="cebbank") String name, Model model){
		return apiService.queryBank(name);
	}
    
    @ApiOperation(value="queryAccount",notes="requires noting")
    @RequestMapping(value="/queryAccount",method=RequestMethod.GET)
    public User queryAccount(@RequestParam(value="name", required=false, defaultValue="user01") String name, Model model){
		return apiService.queryAccount(name);
	}
    
    @ApiOperation(value="queryTreaty",notes="requires noting")
    @RequestMapping(value="/queryTreaty",method=RequestMethod.GET)
    public SmartContract queryTreaty(@RequestParam(value="name", required=false, defaultValue="treaty01") String name, Model model){
        return apiService.querySmartContract(name);
    }
    
    @ApiOperation(value="queryTreaties",notes="requires noting")
    @RequestMapping(value="/queryTreaties",method=RequestMethod.GET)
    public List<SmartContract> queryTreaties(@RequestParam(value="name", required=false, defaultValue="treaty01") String name, Model model){
        return apiService.querySmartContracts(name);
    }
    
    @ApiOperation(value="queryContract",notes="requires noting")
    @RequestMapping(value="/queryContract",method=RequestMethod.GET)
    public Contract queryContract(@RequestParam(value="name", required=false, defaultValue="contract01") String name, Model model){
		return apiService.queryContract(name);
	}
    
    @ApiOperation(value="queryContracts",notes="requires noting")
    @RequestMapping(value="/queryContracts",method=RequestMethod.GET)
    public List<Contract> queryContracts(@RequestParam(value="name", required=false, defaultValue="contract01") String name, Model model){
		return apiService.queryContracts(name);
	}
    
    @ApiOperation(value="queryDonor",notes="requires noting")
    @RequestMapping(value="/queryDonor",method=RequestMethod.GET)
    public User queryDonor(@RequestParam(value="name", required=false, defaultValue="user01") String name, Model model){
        return apiService.queryDonor(name);
    }
    
    @ApiOperation(value="coinbase",notes="requires noting")
    @RequestMapping(value="/coinbase",method=RequestMethod.GET)
    public void coinbase(@RequestParam(value="name", required=false, defaultValue="user01") String name, Model model){
        apiService.coinbase(name);
    }
    
    @ApiOperation(value="changeCoin",notes="requires noting")
    @RequestMapping(value="/changeCoin",method=RequestMethod.GET)
    public void changeCoin(@RequestParam(value="name", required=false, defaultValue="user01") String name, Model model){
        apiService.changeCoin(name);
    }
    
    @ApiOperation(value="donated",notes="requires noting")
    @RequestMapping(value="/donated",method=RequestMethod.GET)
    public String donated(@RequestParam(value="name", required=false, defaultValue="contract01") String name, Model model){
		return apiService.donated(name);
	}
	
	@ApiOperation(value="drawed",notes="requires noting")
    @RequestMapping(value="/drawed",method=RequestMethod.GET)
    public String drawed(@RequestParam(value="name", required=false, defaultValue="contract01") String name, Model model){
		return apiService.drawed(name);
	}
	
	
	@ApiOperation(value="destroycoinbase",notes="requires noting")
    @RequestMapping(value="/destroycoinbase",method=RequestMethod.GET)
    public String destroycoinbase(@RequestParam(value="name", required=false, defaultValue="contract01") String name, Model model){
		return apiService.destroycoinbase(name);
	}
	
	
    /***********************************分割线***********************************************/
	
	
	@ApiOperation(value="viewTreaty",notes="requires noting")
    @RequestMapping(value="/viewTreaty",method=RequestMethod.GET)
    public SmartContract viewTreaty(@RequestParam(value="name", required=false, defaultValue="contract01") String name, Model model){
		return apiService.viewTreaty(name);
	}
	

}
