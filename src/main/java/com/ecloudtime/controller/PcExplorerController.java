package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.BlockHighGen;
import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.DonorTrackDetail;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SysDonorDrawTransRel;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.MoneyUtil;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/explorer")
public class PcExplorerController extends BaseController{

    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;

    
    @Autowired
   	private CommonService commonService;
    
    @Value("${chaincode.base.hostip1}")
	private String hostip1;
    
    @Value("${chaincode.base.hostip2}")
    private String hostip2;
    
    @Value("${chaincode.base.hostip3}")
    private String hostip3;
    
    @Value("${chaincode.base.hostip4}")
    private String hostip4;
   
    @Value("${chaincode.base.hostname1}")
    private String hostname1;
    @Value("${chaincode.base.hostname2}")
    private String hostname2;
    @Value("${chaincode.base.hostname3}")
    private String hostname3;
    @Value("${chaincode.base.hostname4}")
    private String hostname4;
    
    
    @Value("${chaincode.base.nodeUrl}")
   	private String nodeUrl;
    
    @Autowired
	private CacheManager cacheManager;
    
    @Autowired
    private BlockInfoService blockInfoService;
	    
    @RequestMapping("/index")
	@ApiOperation(value="index",notes="requires login Name default user01")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "donor01") String name,
			Model model) {
		model.addAttribute("name", name);
		List<BlockHighGen> blockHighList=blockInfoService.getNewBlockFromStack();
		model.addAttribute("blockHighList", blockHighList);
		List<Transaction> transList =blockInfoService.getNewTransactionFromStack();
		model.addAttribute("transList", transList);
		model.addAttribute("hostip1", hostip1);
		model.addAttribute("hostip2", hostip2);
		model.addAttribute("hostip3", hostip3);
		model.addAttribute("hostip4", hostip4);
		model.addAttribute("hostname1", hostname1);
		model.addAttribute("hostname2", hostname2);
		model.addAttribute("hostname3", hostname3);
		model.addAttribute("hostname4", hostname4);
		model.addAttribute("currentPeerUrl", nodeUrl+"/chain");
		
		return "explorer/index";
	}
    
   /* 
    @RequestMapping("/index")
   	@ApiOperation(value="index",notes="requires login Name default user01")
   	public String index(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
   			Model model) {
   		model.addAttribute("name", name);
   		List<BlockHighGen> blockHighList=blockInfoService.getNewerBolckHighTimes();
   		model.addAttribute("blockHighList", blockHighList);
   		List<Transaction> transList =blockInfoService.getNewerTransactions();
   		model.addAttribute("transList", transList);
   		model.addAttribute("hostip1", hostip1);
   		model.addAttribute("hostip2", hostip2);
   		model.addAttribute("hostip3", hostip3);
   		model.addAttribute("hostip4", hostip4);
   		model.addAttribute("hostname1", hostname1);
   		model.addAttribute("hostname2", hostname2);
   		model.addAttribute("hostname3", hostname3);
   		model.addAttribute("hostname4", hostname4);
   		model.addAttribute("currentPeerUrl", nodeUrl+"/chain");
   		
   		return "explorer/index";
   	}*/
    
    @RequestMapping("/blockDetail")
   	@ApiOperation(value="blockDetail",notes="requires login Name default user01")
   	public String blockDetail(@RequestParam(value = "heigh", required = false, defaultValue = "0") int heigh,
   			@RequestParam(value = "type", required = false, defaultValue = "explorer") String type,
   			Model model) {
   		model.addAttribute("heigh", heigh);
   		model.addAttribute("type", type);
   		int cacheHigh=this.cacheManager.getCacheBlockHigh();
   		BlockInfo blockInfo=new BlockInfo();
   		blockInfo=blockInfoService.queryBlockByHigh(heigh-1);
   		/*if(heigh<cacheHigh&&0!=cacheHigh){
   		}*/
   		model.addAttribute("blockInfo", blockInfo);
   		return "explorer/blockDetail";
   	}
    
    @RequestMapping("/transDetail")
   	@ApiOperation(value="transDetail",notes="requires login Name default user01")
   	public String transDetail(@RequestParam(value = "txid", required = false, defaultValue = "0") String txid,
   			Model model) {
   		model.addAttribute("txid", txid);
   		Transaction transaction =blockInfoService.queryTransactionByTxId(txid);
   		SysDonorDrawTransRel donorTransRel=this.commonService.findDonorTransRelByTxid(txid);
   		if(null!=donorTransRel){
   			DonorTrackDetail donorTrackDetail =(DonorTrackDetail)this.cacheManager.getCacheObjectByKey("donorTrackDetail_"+donorTransRel.getTransId());
   			if(null==donorTrackDetail||null==donorTrackDetail.getDonorid()){
   				this.apiService.putTrackDetailToSession(donorTransRel.getTransId(),donorTransRel.getDonorAddr());
   				donorTrackDetail =(DonorTrackDetail)this.cacheManager.getCacheObjectByKey("donorTrackDetail_"+donorTransRel.getTransId());
   			}
   			model.addAttribute("donorTrackDetail", donorTrackDetail);
   			SmartContract smartContract=this.apiService.querySmartContract(donorTransRel.getContractId());
   			model.addAttribute("smartContract", smartContract);
   		}else{
   			donorTransRel=new SysDonorDrawTransRel();
   		}
   		model.addAttribute("transaction", transaction);
   		model.addAttribute("donorTransRel", donorTransRel);
   		return "explorer/transDetail";
   	}
    
    @RequestMapping("/searchDetail")
   	@ApiOperation(value="searchDetail",notes="requires login Name default user01")
   	public String searchDetail(@RequestParam(value = "searchVal", required = false, defaultValue = "0") String searchVal,
   			Model model) {
   		if(searchVal.length()<4){//根据高度查询
   			try {
				int high =Integer.parseInt(searchVal);
				if(high==0){
					return "explorer/searchDetail"; 
				}
				String url=nodeUrl+"/chain";
				int currentHigh=this.blockInfoService.getCurrentHigh(url);
				if(high<=currentHigh){
					return blockDetail(high,"",model);
				}
			} catch (NumberFormatException e) {
				return "explorer/searchDetail"; 
			}
   		}else{
//   			SysDonorDrawTransRel sysDonorDrawTransRel=this.commonService.findDonorTransRelByTxid(searchVal);
   			Transaction transaction =blockInfoService.queryTransactionByTxId(searchVal);
   			if(null!=transaction){
   				return transDetail(searchVal,model);
   			}
   		}
   		return "explorer/searchDetail"; 
   	}
    
    
    public static void main(String[] args) {
    	System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        String donorAmount="90000";
        System.out.println(MoneyUtil.moneyToCcFormat(donorAmount));
        System.out.println(MoneyUtil.moneyToCcFormat(donorAmount));
	}
}
