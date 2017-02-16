package com.ecloudtime.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.DonorContribution;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.SessionUtils;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/app")
public class AppController extends BaseController{


    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;
    
    /*@RequestMapping("index")
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
   	}*/
    
    @RequestMapping("/queryDonorHis")
	@ApiOperation(value="queryDonorHis",notes="requires login Name")
	public String queryDonorHis(Model model) {
//		name="donor01";
		String userName=SessionUtils.getUserNameFromSession();
		model.addAttribute("name", userName);
		if(null==userName)userName="donor01";
		User user =apiService.queryDonor(userName);
		List<DonorContribution> donorHisList=user.getContributions();
		model.addAttribute("donorHisList", donorHisList);
		return "app/queryDonorHis";
	}
	
	/**
	 * 
	 * @param donorid
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryDonorDeatail")
	@ApiOperation(value="queryDonorDeatail",notes="requires login Name")
	public String queryDonorDeatail(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		model.addAttribute("donorid", donorid);
//		User user =apiService.queryDonor(name);
//		List<DonorContribution> donorHisList=user.getContributions();
//		model.addAttribute("donorHisList", donorHisList);
		return "app/queryDonorDeatail";
	}
	
	/**
	 * 善款追踪
	 * @param donorid
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryDonatedContract")
	@ApiOperation(value="queryDonatedContract",notes="requires login Name")
	public String queryDonatedContract(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		List<DonorContribution> contributionsList=user.getContributions();
		Map<String,DonorContribution> dcMap  = new HashMap<String,DonorContribution>();
//		DonorContribution donorContribution=new DonorContribution();
		for(DonorContribution dct :contributionsList){
			DonorContribution donorContribution=null;
			if(dcMap.containsKey(dct.getSmartContractAddr())){
				donorContribution=(DonorContribution)dcMap.get(dct.getSmartContractAddr());
			}else{
				donorContribution=dct.clone();
				donorContribution.setAmount(0);
				donorContribution.setDonorNumber(0);
			}
			donorContribution.setAmount(donorContribution.getAmount()+dct.getAmount());
			donorContribution.setDonorNumber(donorContribution.getDonorNumber()+1);
			donorContribution.setSmartContract(this.apiService.querySmartContract(dct.getSmartContractAddr()));
			//这个查询 合约的 需要修改   --todo
			dcMap.put(dct.getSmartContractAddr(), donorContribution);
		}
		contributionsList=new ArrayList<DonorContribution>();
		for (String key : dcMap.keySet()) {
			   //System.out.println("key= "+ key + " and value= " + dcMap.get(key));
			   contributionsList.add(dcMap.get(key));
		}
		model.addAttribute("contributionsList", contributionsList);
		return "app/queryDonatedContract";
	}
	
	/**
	 * 查看合约详情
	 * @param itemid
	 * @param model
	 * @return
	 */
	@RequestMapping("/querySmartContract")
	@ApiOperation(value="querySmartContract",notes="requires login Name")
	public String querySmartContract(@RequestParam(value = "smartContractAddr", required = false, defaultValue = "smartContractAddr") String smartContractAddr,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		SmartContract smartContract =(SmartContract)this.apiService.querySmartContract(smartContractAddr);
		model.addAttribute("smartContract", smartContract);
		return "app/querySmartContract";
	}
	
	/**
	 * 查询合同项目相关情况
	 * @param itemid
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryBargain")
	@ApiOperation(value="queryItemDetail",notes="requires login Name")
	public String queryItemDetail(@RequestParam(value = "itemid", required = false, defaultValue = "itemid") String itemid,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
	
		return "app/queryBargain";
	}
	
	@RequestMapping("/queryBargainDraw")
	@ApiOperation(value="queryBargainDraw",notes="requires login Name")
	public String queryBargainDraw(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		
		return "app/queryBargainDraw";
	}
	
	
	@RequestMapping("/queryBargainContract")
	@ApiOperation(value="queryBargainContract",notes="requires login Name")
	public String queryBargainContract(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		
		return "app/queryBargainContract";
	}
	@RequestMapping("/queryBargainImages")
	@ApiOperation(value="queryBargainImages",notes="requires login Name")
	public String queryBargainImages(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		
		return "app/queryBargainImages";
	}
	@RequestMapping("/queryBargainCheck")
	@ApiOperation(value="queryBargainCheck",notes="requires login Name")
	public String queryItemDetailCheck(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		
		return "app/queryBargainCheck";
	}
    
}
