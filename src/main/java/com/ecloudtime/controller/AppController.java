package com.ecloudtime.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.BargainTrack;
import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.DonorContribution;
import com.ecloudtime.model.DonorTrack;
import com.ecloudtime.model.DonorTrackDetail;
import com.ecloudtime.model.ProcessDonored;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SmartContractExt;
import com.ecloudtime.model.SmartContractTrack;
import com.ecloudtime.model.SysDonorDrawTransRel;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.DateUtil;
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
		List<DonorContribution> donorHisTempList=user.getContributions();
		List<DonorContribution> donorHisList =new ArrayList<DonorContribution>();
		if(null!=donorHisTempList&&donorHisTempList.size()>0){
			int len=donorHisTempList.size();
			for(int i=len-1;i>=0;i--){
				donorHisList.add(donorHisTempList.get(i));
				if(donorHisList.size()>10){
					break;
				}
			}
		}
		model.addAttribute("donorHisList", donorHisList);
		if(0==donorHisList.size()){
			return "app/queryDonorHisNull";
		}
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
		if(null!=conList){
			for(DonorContribution dct :conList){
				if(donorid.equals(dct.getDonorid())){
					donorContribution=dct;
					break;
				}
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
//		model.addAttribute("smartContractTrack", this.apiService.querySmartContractTrack(donorContribution.getSmartContractAddr()));
		
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
		SysDonorDrawTransRel donorTransRel=null;//this.commonService.findDonorTransRelByDonorid(donorid);
		donorTransRel=this.commonService.findDonorTransRelByDonorid(donorid);
		if(null==donorTransRel)return "app/queryDonorTransDeatail";
		txid=donorTransRel.getTxid();
		model.addAttribute("txid", txid);
   		Transaction transaction =blockInfoService.queryTransactionByTxId(txid);
   		model.addAttribute("transaction", transaction);
   		model.addAttribute("donorTransRel", donorTransRel);
		if("donor".equals(type)){
			DonorTrackDetail donorTrackDetail =(DonorTrackDetail)this.cacheManager.getCacheObjectByKey("donorTrackDetail_"+donorid);
			if(null==donorTrackDetail||null==donorTrackDetail.getDonorid()){
				User user =SessionUtils.getUserFromSession();
				this.apiService.putTrackDetailToSession(donorid,user.getAddr());
				donorTrackDetail =(DonorTrackDetail)this.cacheManager.getCacheObjectByKey("donorTrackDetail_"+donorid);
			}
			model.addAttribute("donorTrackDetail", donorTrackDetail);
		}else{//提款
			model.addAttribute("donorTrackDetail", new DonorTrackDetail());
		}
		
   		
//      SysDonorTransRel donorTransRel=this.commonService.findDonorTransRelByTxid(txid);
		
   		
   		
   		
		
		
	    return "app/queryDonorTransDeatail";  
	}
	
	/**
	 * 查询区块详情
	 * @param heigh
	 * @param model
	 * @return
	 */
	@RequestMapping("/appBlockDetail")
   	@ApiOperation(value="appBlockDetail",notes="requires login Name default user01")
   	public String appBlockDetail(@RequestParam(value = "heigh", required = false, defaultValue = "0") int heigh,
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
	 * 善款去向
	 * @param smartContractAddr
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryContributeGo")
   	@ApiOperation(value="queryContributeGo",notes="requires login Name default user01")
   	public String queryContributeGo(@RequestParam(value = "smartContractAddr", required = false, defaultValue = "smartContractAddr") String smartContractAddr,
   			@RequestParam(value = "donateYuan", required = false, defaultValue = "100") String donateYuan,
			Model model) {
		SmartContractExt smartContractExt=this.apiService.querySmartContractExt(smartContractAddr);
		SmartContractTrack  smartContractTrack =this.apiService.querySmartContractTrack(smartContractAddr);
		model.addAttribute("smartContractExt", smartContractExt);
		model.addAttribute("smartContractTrack", smartContractTrack);
		model.addAttribute("donateYuan", donateYuan);
   		return "app/queryContributeGo";
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
		if(null!=contributionsList){
			for(DonorContribution dct :contributionsList){
				DonorContribution donorContribution=null;
				if(dcMap.containsKey(dct.getSmartContractAddr())){
					donorContribution=(DonorContribution)dcMap.get(dct.getSmartContractAddr());
				}else{
					donorContribution=dct.clone();
					donorContribution.setAmount(0);
					donorContribution.setDonorNumber(0);
					donorContribution.setSmartContractExt(apiService.querySmartContractExt(dct.getSmartContractAddr()));
				}
				donorContribution.setAmount(donorContribution.getAmount()+dct.getAmount());
				donorContribution.setDonorNumber(donorContribution.getDonorNumber()+1);
//				donorContribution.setSmartContract(this.apiService.querySmartContract(dct.getSmartContractAddr()));
				//这个查询 合约的 需要修改   --todo
				dcMap.put(dct.getSmartContractAddr(), donorContribution);
			}
		}
		
		contributionsList=new ArrayList<DonorContribution>();
		for (String key : dcMap.keySet()) {
			   contributionsList.add(dcMap.get(key));
		}
		model.addAttribute("contributionsList", contributionsList);
		if(0==contributionsList.size()){
			return "app/queryDonatedContractNull";
		}
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
		SmartContractExt SmartContractExt =this.apiService.querySmartContractExt(smartContractAddr);
//		SmartContract smartContract =(SmartContract)this.apiService.querySmartContract(smartContractAddr);
		SmartContract smartContract= this.commonService.findContractInfo(SmartContractExt.getSmartContract());
		model.addAttribute("SmartContractExt", SmartContractExt);
		model.addAttribute("smartContract", smartContract);
		return "app/querySmartContract";
	}
	
	@RequestMapping("/donate")
	@ApiOperation(value="donate",notes="requires login Name")
	public String donate(@RequestParam(value = "donorAmount", required = false, defaultValue = "donorAmount") String donorAmount,
			@RequestParam(value = "smartContractAddr", required = false, defaultValue = "smartContract01") String smartContractAddr,
			Model model) {
		String donorName=SessionUtils.getUserNameFromSession();//User user =SessionUtils.getUserFromSession();
		String msg ="error";
		SysDonorDrawTransRel donorRel=this.apiService.donated(donorName, donorAmount,smartContractAddr);
		model.addAttribute("donorRel", donorRel);
		return ccpaySuccess(donorAmount,smartContractAddr,donorRel.getTransId(),model);
	}
	
	/**
	 * 
	 * @param donorAmount
	 * @param smartContractAddr
	 * @param model
	 * @return
	 */
	@RequestMapping("/ccpay")
	@ApiOperation(value="ccpay",notes="requires login Name")
	public String ccpay(@RequestParam(value = "donorAmount", required = false, defaultValue = "donorAmount") String donorAmount,
			@RequestParam(value = "smartContractAddr", required = false, defaultValue = "smartContract01") String smartContractAddr,
			Model model) {
		SmartContractExt  smartContractExt =this.apiService.querySmartContractExt(smartContractAddr);
		model.addAttribute("smartContractExt", smartContractExt);
		Random random = new Random();
		model.addAttribute("orderNum", DateUtil.getDaysyyyyMMddHHmmss()+random.nextInt(1000));
		model.addAttribute("donorAmount", donorAmount);
		model.addAttribute("smartContractAddr", smartContractAddr);
		return "app/ccpay";
	}
	
	@RequestMapping("/ccpaySuccess")
	@ApiOperation(value="ccpaySuccess",notes="requires login Name")
	public String ccpaySuccess(@RequestParam(value = "donorAmount", required = false, defaultValue = "donorAmount") String donorAmount,
			@RequestParam(value = "smartContractAddr", required = false, defaultValue = "smartContract01") String smartContractAddr,
			@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		model.addAttribute("donorAmount", donorAmount);
		model.addAttribute("smartContractAddr", smartContractAddr);
		model.addAttribute("donorid", donorid);
		return "app/ccpaySuccess";
	}
	@RequestMapping("/donateInfo")
	@ApiOperation(value="donateInfo",notes="requires login Name")
	public String donateInfo(@RequestParam(value = "donorid", required = false, defaultValue = "donorid") String donorid,
			Model model) {
		model.addAttribute("donorid", donorid);
		return "app/donateInfo";
	}
	
	@RequestMapping("/draw")
	@ApiOperation(value="draw",notes="requires login Name")
	public String draw(@RequestParam(value = "donorAmount", required = false, defaultValue = "donorAmount") String donorAmount,
			Model model) {
		String donorName=SessionUtils.getUserNameFromSession();//User user =SessionUtils.getUserFromSession();
		String msg ="error";
		/*@RequestParam(value = "fundName", required = false, defaultValue = "fund01") String fundName
		,@RequestParam(value = "drawAmount", required = false, defaultValue = "100") String drawAmount
		,@RequestParam(value = "smartContractName", required = false, defaultValue = "smartcontract01") String smartContractName
		,@RequestParam(value = "bargainName", required = false, defaultValue = "bargain01") String bargainName*/
		String fundName="fund01";
		String smartContractName="";
		String bargainName="";
		String drawAmount="100";
		SysDonorDrawTransRel drawRel=this.apiService.drawed(fundName, drawAmount,smartContractName,bargainName);
		model.addAttribute("drawRel", drawRel);
		return "app/drawInfo";
	}
	
	/**
	 * 查询合同项目相关情况
	 * @param itemid
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryBargain")
	@ApiOperation(value="queryBargain",notes="requires login Name")
	public String queryBargain(@RequestParam(value = "bargainName", required = false, defaultValue = "bargain01") String bargainName,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		String bargainAddr="bargain01:8fcc58ea7ed212f7c1ba359d15bea144e67c390044d953797548cf67fd62534a";
		model.addAttribute("bargainAddr", bargainAddr);
		return "app/queryBargain";
	}
	
	@RequestMapping("/queryBargainDraw")
	@ApiOperation(value="queryBargainDraw",notes="requires login Name")
	public String queryBargainDraw(@RequestParam(value = "bargainAddr", required = false, defaultValue = "bargainAddr") String bargainAddr,
			Model model) {
		String userName=SessionUtils.getUserNameFromSession();
		User user =SessionUtils.getUserFromSession();
		BargainTrack bargainTrack =this.apiService.queryBargainTrack(bargainAddr);
		
		model.addAttribute("bargainTrack", bargainTrack);
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
