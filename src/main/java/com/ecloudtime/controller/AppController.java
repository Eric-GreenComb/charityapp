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

import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.DonorContribution;
import com.ecloudtime.model.DonorTrack;
import com.ecloudtime.model.DonorTrackDetail;
import com.ecloudtime.model.ProcessDonored;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SysDonorTransRel;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.SessionUtils;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/app")
public class AppController extends BaseController{


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
		List<DonorContribution> donorHisList =new ArrayList<DonorContribution>();
		List<DonorContribution> donorHisTempList=user.getContributions();
		int len=donorHisTempList.size();
		for(int i=len-1;i>0;i--){
			donorHisList.add(donorHisTempList.get(i));
			if(donorHisList.size()>10){
				break;
			}
		}
		
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
		String userName=SessionUtils.getUserNameFromSession();
		model.addAttribute("name", userName);
		User user =SessionUtils.getUserFromSession();
		List<DonorContribution> conList=user.getContributions();
		DonorContribution donorContribution=new DonorContribution();
		for(DonorContribution dct :conList){
			if(donorid.equals(dct.getDonorid())){
				donorContribution=dct;
				break;
			}
		}
		
		List<DonorTrack>  trackings= new ArrayList<DonorTrack>();
		for(DonorTrack dt :user.getTrackings()){
			if(donorid.equals(dt.getDonorid())){
				trackings.add(dt);
			}
		}
		ProcessDonored processDonored =this.apiService.queryProcessDonored(donorid);
		
		donorContribution.setSmartContract(this.apiService.querySmartContract(donorContribution.getSmartContractAddr()));
		
		model.addAttribute("donorContribution", donorContribution);
		
		model.addAttribute("trackings", trackings);
		model.addAttribute("processDonored", processDonored);
		DonorTrackDetail donorTrackDetail =new DonorTrackDetail(trackings);
		model.addAttribute("donorTrackDetail", donorTrackDetail);
		 this.cacheManager.putObjectToCache("donorTrackDetail_"+donorid, donorTrackDetail);
//		SysDonorTransRel donorTransRel=new SysDonorTransRel(donorid);
//		donorTransRel=this.commonService.findDonorTransRel(donorTransRel);
//		model.addAttribute("donorTransRel", this.commonService.findDonorTransRel(new SysDonorTransRel(donorid)));
//		model.addAttribute("donorTransRel", donorTransRel);
		
		return "app/queryDonorDeatail";
	}
	
	@RequestMapping("/queryDonorTransDeatail")
	@ApiOperation(value="queryDonorTransDeatail",notes="requires login Name")
	public String queryDonorTransDeatail(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			@RequestParam(value = "type", required = false, defaultValue = "type") String type,
			Model model) {
		String txid="";
		if("donor".equals(type)){
			SysDonorTransRel donorTransRel=this.commonService.findDonorTransRelByDonorid(donorid);
			if(null==donorTransRel)return "app/queryDonorTransDeatail";
			txid=donorTransRel.getTxid();
		}else{
			
		}
		model.addAttribute("txid", txid);
   		Transaction transaction =blockInfoService.queryTransactionByTxId(txid);
   		
   		SysDonorTransRel donorTransRel=this.commonService.findDonorTransRelByTxid(txid);
		DonorTrackDetail donorTrackDetail =(DonorTrackDetail)this.cacheManager.getCacheObjectByKey("donorTrackDetail_"+donorid);
//		this.cacheManager.putObjectToCache("donorTrackDetail_"+donorid, donorTrackDetail);
   		model.addAttribute("transaction", transaction);
   		model.addAttribute("donorTrackDetail", donorTrackDetail);
   		model.addAttribute("donorTransRel", donorTransRel);
		
		
	    return "app/queryDonorTransDeatail";  
	}
	
	@RequestMapping("/blockDetail")
   	@ApiOperation(value="blockDetail",notes="requires login Name default user01")
   	public String blockDetail(@RequestParam(value = "heigh", required = false, defaultValue = "0") int heigh,
   			Model model) {
   		model.addAttribute("heigh", heigh);
   		int cacheHigh=this.cacheManager.getCacheBlockHigh();
   		BlockInfo blockInfo=new BlockInfo();
   		blockInfo=blockInfoService.queryBlockByHigh(heigh-1);
   		/*if(heigh<cacheHigh&&0!=cacheHigh){
   		}*/
   		model.addAttribute("blockInfo", blockInfo);
   		return "app/appBlockDetail";
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