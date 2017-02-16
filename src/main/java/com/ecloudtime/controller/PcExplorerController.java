package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.BlockHighGen;
import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.HttpService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/explorer")
public class PcExplorerController extends BaseController{

    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;
    @Autowired
	private CacheManager cacheManager;
    
    @Autowired
    private BlockInfoService blockInfoService;
	    
    @RequestMapping("/index")
	@ApiOperation(value="index",notes="requires login Name default user01")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "user01") String name,
			Model model) {
		model.addAttribute("name", name);
//		getNewerTransactions
		List<BlockHighGen> blockHighList=blockInfoService.getNewerBolckHighTimes();
		model.addAttribute("blockHighList", blockHighList);
		List<Transaction> transList =blockInfoService.getNewerTransactions();
		model.addAttribute("transList", transList);
		return "explorer/index";
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
   		return "explorer/blockDetail";
   	}
    
    @RequestMapping("/transDetail")
   	@ApiOperation(value="transDetail",notes="requires login Name default user01")
   	public String transDetail(@RequestParam(value = "txid", required = false, defaultValue = "0") String txid,
   			Model model) {
   		model.addAttribute("txid", txid);
   		Transaction transaction =blockInfoService.queryTransactionByTxId(txid);
   		model.addAttribute("transaction", transaction);
   		return "explorer/transDetail";
   	}
}
