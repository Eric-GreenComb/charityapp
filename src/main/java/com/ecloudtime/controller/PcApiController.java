package com.ecloudtime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecloudtime.model.BlockHighGen;
import com.ecloudtime.model.BlockInfo;
import com.ecloudtime.model.Transaction;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.HttpService;
import com.wordnik.swagger.annotations.ApiOperation;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="/pcapi")
public class PcApiController extends BaseController{

    @Autowired
    private HttpService httpService;
    @Autowired
    private ApiService apiService;
    
    @Autowired
    private BlockInfoService blockInfoService;
	    
	    
	@ApiOperation(value="queryCurrentPeerStatus",notes="requires noting")
    @RequestMapping(value="/queryCurrentPeerStatus",method=RequestMethod.GET)
    public JSONObject queryCurrentPeerStatus(@RequestParam(value="url", required=false, defaultValue="http://192.168.31.100:7050/chain") String url, Model model){
		return blockInfoService.queryCurrentPeerStatus(url);
	}
	
	@ApiOperation(value="queryBlockHighList",notes="requires noting")
    @RequestMapping(value="/queryBlockHighList",method=RequestMethod.GET)
    public List<BlockHighGen> queryBlockHighList( Model model){
		return blockInfoService.getNewBlockFromStack();
	}
	
	@ApiOperation(value="queryTransList",notes="requires noting")
    @RequestMapping(value="/queryTransList",method=RequestMethod.GET)
    public List<Transaction> queryTransList( Model model){
		return blockInfoService.getNewTransactionFromStack();
	}
	
	@ApiOperation(value="queryBlockByHigh",notes="requires noting")
    @RequestMapping(value="/queryBlockByHigh",method=RequestMethod.GET)
    public BlockInfo queryBlockByHigh(@RequestParam(value="url", required=false, defaultValue="http://192.168.31.100:7050/chain") String url, Model model){
		return blockInfoService.queryBlockByHigh(url);
	}
	
	@ApiOperation(value="queryTransactionByTxId",notes="requires noting")
	@RequestMapping(value="/queryTransactionByTxId",method=RequestMethod.GET)
	public Transaction queryTransactionByTxId(@RequestParam(value="txId", required=false, defaultValue="http://192.168.31.100:7050/chain") String txId, Model model){
		return blockInfoService.queryTransactionByTxId(txId);
	}
	
	@ApiOperation(value="getCurrentHigh",notes="requires noting")
	@RequestMapping(value="/getCurrentHigh",method=RequestMethod.GET)
	public int getCurrentHigh(@RequestParam(value="url", required=false, defaultValue="http://192.168.31.100:7050/chain") String url, Model model){
		return blockInfoService.getCurrentHigh(url);
	}
	
	@ApiOperation(value="getNewerTransactions",notes="requires noting")
	@RequestMapping(value="/getNewerTransactions",method=RequestMethod.GET)
	public  List<Transaction> getNewerTransactions(Model model){
		return blockInfoService.getNewerTransactions();
	}
	
	@ApiOperation(value="getNewerBlocks",notes="requires noting")
	@RequestMapping(value="/getNewerBlocks",method=RequestMethod.GET)
	public  List<BlockInfo> getNewerBlocks(Model model){
		return blockInfoService.getNewerBlocks();
	}
}
