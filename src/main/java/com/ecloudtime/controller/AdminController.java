package com.ecloudtime.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecloudtime.mapper.CommonMapper;
import com.ecloudtime.model.Bargain;
import com.ecloudtime.model.ContractBargain;
import com.ecloudtime.model.ContractBargainList;
import com.ecloudtime.model.Foundation;
import com.ecloudtime.model.ProcessDonored;
import com.ecloudtime.model.ProcessDrawed;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SmartContractExt;
import com.ecloudtime.model.SysDonorDrawTransRel;
import com.ecloudtime.model.TransDetail;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.SessionUtils;
import com.github.pagehelper.PageHelper;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/admin")
public class AdminController extends BaseController{
	
    @Autowired
    private HttpService httpService;
    
    @Autowired
	private CommonService commonService;
    @Autowired
	 private CommonMapper commonMapper;
    
    @Autowired
    private BlockInfoService blockInfoService;
    
    @Autowired
	private CacheManager cacheManager;
    
    @Autowired
    private ApiService apiService;
    
    
    /**
     * 基金管理登录界面
     * @param model
     * @return
     */
    @RequestMapping("/login")
	@ApiOperation(value="login",notes="requires login Name")
	public String login(Model model) {
//		name="donor01";
		String userName=SessionUtils.getUserNameFromSession();
		
		return "admin/login";
	}
    
    @RequestMapping("/login_login")
	@ApiOperation(value="login_login",notes="requires login Name")
	public String login_login(@RequestParam(value = "userName", required = true, defaultValue = "fund01") String userName,
			Model model) {
    	model.addAttribute("userName", userName);
		if(!"".equals(userName)){
			Foundation fund =queryFund(userName);
			Subject subject = SecurityUtils.getSubject(); 
		    UsernamePasswordToken token = new UsernamePasswordToken(userName, userName+"_pwd"); 
		    try { 
		        subject.login(token); 
		    } catch (AuthenticationException e) { 
		    }
			SessionUtils.putFoundUserInfoToSession(fund);
			return index(model,fund,userName);
		}else{
			SessionUtils.clearFoundUserInfoFromSession();
		}
    	
    	return "admin/login";
    }
    
    /**
     * 基金后台管理 首页
     * @param model
     * @return
     */
    @RequestMapping("/index")
  	@ApiOperation(value="index",notes="requires login Name")
  	public String index(Model model,Foundation fund,String fundId) {
    	Foundation fundCache=SessionUtils.getFundUserFromSession();
  		if(null==fundCache)return login(model);
  		if(StringUtils.isEmpty(fund.getAddr())&&!StringUtils.isEmpty(fundCache.getAddr())){
  			fund=fundCache;
  		}
  		
  		model.addAttribute("fund", fund);
  		model.addAttribute("bargainLen", this.commonService.findBargainLen());
  		return "admin/index";
  	}
    
    public Foundation queryFund(String userName){
    	Foundation fund=this.apiService.queryFund(userName);
    	String contracts =fund.getContracts();
    	if(!StringUtils.isEmpty(contracts)){
    		String[] contractArr=contracts.split(",");
        	String smartcontractAddr="";
        	for(String smartContractId:contractArr){
        		smartcontractAddr=this.commonService.findSmartContractAddrById(smartContractId);
        		SmartContractExt smartContract=this.apiService.querySmartContractExt(smartcontractAddr);
        		fund.setChannelFee(fund.getChannelFee()+(smartContract.getTotal()/1000*smartContract.getSmartContract().getChannelFee()));
        		fund.setFundManangerFee(fund.getFundManangerFee()+(smartContract.getTotal()/1000*smartContract.getSmartContract().getFundManangerFee()));
        	}
    	}
    	return fund;
    }
    
    
    /**
     * 我的账本
     * @param model
     * @return
     */
    @RequestMapping("/myAccountBook")
    @ApiOperation(value="myAccountBook",notes="requires login Name")
    public String myAccountBook(
    		@RequestParam(value = "type", required = false, defaultValue = "") String type,
    		@RequestParam(value = "contractId", required = false, defaultValue = "" ) String contractId,
    		@RequestParam(value = "transDate", required = false) String transDate,
    		Model model) {    	Foundation fundCache=SessionUtils.getFundUserFromSession();
  		if(null==fundCache)return login(model);
    	
    	String userName=SessionUtils.getUserNameFromSession();
    	TransDetail td = new TransDetail();
    	if(!StringUtils.isEmpty(contractId)){
    		td.setContractId(contractId);
    	}
    	if(!StringUtils.isEmpty(type)){
    		td.setType(type);
    	}
    	if(!StringUtils.isEmpty(transDate)){
    		td.setTransTime(transDate);
    	}
    	PageHelper.startPage(1, 15);
    	List<TransDetail> transDetailList=this.commonMapper.queryTransDetailsList(td);;
    	
    	String allContractStr=commonService.findAllSmartContractS();//查询数据
		List<SmartContractExt> allSmartcontracts= apiService.querySmartContractExts(allContractStr);
    	
    	model.addAttribute("userName", userName);
    	model.addAttribute("type", type);
    	model.addAttribute("contractId", contractId);
    	model.addAttribute("transDate", transDate);
    	model.addAttribute("fund", fundCache);
    	model.addAttribute("transDetailList", transDetailList);
    	model.addAttribute("allSmartcontracts", allSmartcontracts);
    	return "admin/myAccountBook";
    }
    
    @ApiOperation(value="queryTransDetail",notes="requires noting")
    @RequestMapping(value="/queryTransDetail",method=RequestMethod.GET)
    @ResponseBody
    public Object queryTransDetail(
    		@RequestParam(value="transId", required=false, defaultValue="transId") String transId,
    		@RequestParam(value="type", required=false, defaultValue="1") String type,
    		Model model){
    	if("1".equals(type)){
    		ProcessDonored processDonored =this.apiService.queryProcessDonored(transId);
    		return processDonored;
    	}else{
    		ProcessDrawed processDrawed=this.apiService.queryProcessDrawed(transId);
    		return processDrawed;
    	}
	}
    
    @ApiOperation(value="querySmartContractDetail",notes="requires noting")
    @RequestMapping(value="/querySmartContractDetail",method=RequestMethod.GET)
    @ResponseBody
    public Object querySmartContractDetail(
    		@RequestParam(value="smartContractAddr", required=false, defaultValue="smartContract01") String smartContractAddr,
    		Model model){
    	if(!"".equals(smartContractAddr)){
    		SmartContractExt smartContractExt=this.apiService.querySmartContractExt(smartContractAddr);
    		List<ContractBargain> contractList =this.commonService.findContractBargainList(smartContractAddr.split(":")[0]);
    		
    		ContractBargainList contractBargainList = new ContractBargainList();
    		contractBargainList.setSmartContractExt(smartContractExt);
    		contractBargainList.setContractBargainList(contractList);
    		
    		return contractBargainList;
    	}
    	return new ArrayList();
    }
    
    @ApiOperation(value="querySmartContractExt",notes="requires noting")
    @RequestMapping(value="/querySmartContractExt",method=RequestMethod.GET)
    @ResponseBody
    public Object querySmartContractExt(
    		@RequestParam(value="smartContractAddr", required=false, defaultValue="smartContract01") String smartContractAddr,
    		Model model){
    	SmartContractExt smartContractExt=this.apiService.querySmartContractExt(smartContractAddr);
    	return smartContractExt;
    }
    
    @ApiOperation(value="draw",notes="requires noting")
    @RequestMapping(value="/draw",method=RequestMethod.GET)
    @ResponseBody
    public Object draw(@RequestParam(value = "fundName", required = false, defaultValue = "fund01") String fundName
			,@RequestParam(value = "drawAmount", required = false, defaultValue = "100") String drawAmount
			,@RequestParam(value = "smartContractId", required = false, defaultValue = "smartcontract01") String smartContractId
			,@RequestParam(value = "bargainAddr", required = false, defaultValue = "bargainAddr") String bargainAddr
			,@RequestParam(value = "drawRemark", required = false, defaultValue = "drawRemark") String drawRemark){
    	
    	SysDonorDrawTransRel sysDonorDrawTransRel=this.apiService.drawed(fundName, drawAmount, smartContractId, bargainAddr,drawRemark);
    	if(null!=sysDonorDrawTransRel&&!StringUtils.isEmpty(sysDonorDrawTransRel.getTransId())){
    		Foundation fund =queryFund(SessionUtils.getFundUserFromSession().getAddr());
    		SessionUtils.putFoundUserInfoToSession(fund);
    	}
    	
    	return sysDonorDrawTransRel;
    }
    
    
    
    
    /**
     * 捐献合约列表
     * @param model
     * @return
     */
    @RequestMapping("/donateContractList")
    @ApiOperation(value="donateContractList",notes="requires login Name")
    public String donateContractList(Model model) {
    	String allContractStr=commonService.findAllSmartContractS();//查询数据
		List<SmartContractExt> smartContractExts= apiService.querySmartContractExts(allContractStr);
		model.addAttribute("smartContractExts", smartContractExts);
		SmartContractExt smartContractExt =this.apiService.querySmartContractExt("smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8");
		return "admin/donateContractList";
    }
    
    /**
     * 施工合同列表
     * @param model
     * @return
     */
    @RequestMapping("/bargainItemList")
    @ApiOperation(value="bargainItemList",notes="requires login Name")
    public String bargainItemList(Model model) {
//  		name="donor01";
    	String userName=SessionUtils.getUserNameFromSession();
    	String bargainAddrs=this.commonService.findAllBargainS();
    	List<Bargain> bargainList=this.apiService.queryBargains(bargainAddrs);
    	model.addAttribute("bargainList", bargainList);
    	return "admin/bargainItemList";
    }
    
    /**
     * 施工合同详情
     * @param bargainAddr
     * @param model
     * @return
     */
    @ApiOperation(value="queryBargainExt",notes="requires noting")
    @RequestMapping(value="/queryBargainExt",method=RequestMethod.GET)
    @ResponseBody
    public Object queryBargainExt(
    		@RequestParam(value="bargainAddr", required=false, defaultValue="bargainAddr01") String bargainAddr,
    		Model model){
    	Bargain  bargain = this.apiService.queryBargain(bargainAddr);
    	return bargain;
    }
    
}
