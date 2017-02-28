package com.ecloudtime.controller;

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

import com.ecloudtime.model.Foundation;
import com.ecloudtime.model.ProcessDonored;
import com.ecloudtime.model.ProcessDrawed;
import com.ecloudtime.model.TransDetail;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.BlockInfoService;
import com.ecloudtime.service.CacheManager;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.service.HttpService;
import com.ecloudtime.utils.SessionUtils;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/admin")
public class AdminController extends BaseController{
	
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
			Foundation fund =apiService.queryFund(userName);
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
  		return "admin/index";
  	}
    /**
     * 我的账本
     * @param model
     * @return
     */
    @RequestMapping("/myAccountBook")
    @ApiOperation(value="myAccountBook",notes="requires login Name")
    public String myAccountBook(
    		@RequestParam(value = "type", required = false, defaultValue = "1") String type,
    		@RequestParam(value = "smartContractId", required = false, defaultValue = "smartcontract01") String smartContractId,
    		@RequestParam(value = "transDate", required = false, defaultValue = "2017-01-01") String transDate,
    		Model model) {
//  		name="donor01";
    	String userName=SessionUtils.getUserNameFromSession();
    	TransDetail td = new TransDetail();
    	List<TransDetail> transDetailList=this.commonService.findTransDetailsList(td);
    	
    	
    	model.addAttribute("userName", userName);
    	model.addAttribute("transDetailList", transDetailList);
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
	
    
    /**
     * 捐献合约列表
     * @param model
     * @return
     */
    @RequestMapping("/donateContractList")
    @ApiOperation(value="donateContractList",notes="requires login Name")
    public String donateContractList(Model model) {
//  		name="donor01";
    	String userName=SessionUtils.getUserNameFromSession();
    	
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
    	
    	return "admin/bargainItemList";
    }
}
