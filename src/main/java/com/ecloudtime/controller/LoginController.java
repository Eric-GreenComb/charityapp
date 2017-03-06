package com.ecloudtime.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.SmartContractExt;
import com.ecloudtime.model.User;
import com.ecloudtime.service.ApiService;
import com.ecloudtime.service.CommonService;
import com.ecloudtime.utils.Const;
import com.ecloudtime.utils.SessionUtils;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
    private ApiService apiService;
	
	 @Autowired
	 private CommonService commonService;
	 
	 @RequestMapping("/")
		@ApiOperation(value="/",notes="requires login Name")
		public String loginDirect(@RequestParam(value = "name", required = false, defaultValue = "name") String name,
				Model model) {
			return login(name,model);
		}
	
	@RequestMapping("/403")
	@ApiOperation(value="login",notes="requires login Name")
	public String loginNotAuth(@RequestParam(value = "name", required = false, defaultValue = "name") String name,
			Model model) {
		model.addAttribute("name", name);
		return "403";
	}
	
	@RequestMapping("/login")
	@ApiOperation(value="login",notes="requires login Name")
	public String login(@RequestParam(value = "name", required = false, defaultValue = "name") String name,
			Model model) {
		model.addAttribute("name", name);
		return "login";
	}
	
	@RequestMapping("/login_login")
	@ApiOperation(value="login_login",notes="requires login Name")
	public String login_login(@RequestParam(value = "userName", required = true, defaultValue = "donor01") String userName,
			@RequestParam(value = "isFake", required = true, defaultValue = "false") String isFake,
			Model model) {
		model.addAttribute("userName", userName);
		if(Boolean.valueOf(isFake)){
			userName="donor01";
		}
		
		if(!"".equals(userName)){
			String userAddr=this.commonService.findDonorAddrById(userName);
			if(StringUtils.isEmpty(userAddr)){
				model.addAttribute("noExistUser", "yes");
				return "login";
			}
			
			User user =apiService.queryDonor(userAddr);
			user.setName(userName);
			Subject subject = SecurityUtils.getSubject(); 
		    UsernamePasswordToken token = new UsernamePasswordToken(userName, userName+"_pwd"); 
		    try { 
		        subject.login(token); 
		    } catch (AuthenticationException e) { 
		    }
			SessionUtils.putUserInfoToSession(user);
			return index(model);
		}
		return "login";
	}
	
	@RequestMapping("/index")
	@ApiOperation(value="index",notes="requires login Name default user01")
	public String index(Model model) {
		User user =SessionUtils.getUserFromSession();
		if(null==user.getName())user.setName("donor01");
		model.addAttribute("user", user);
		 
		String allContractStr=commonService.findAllSmartContractS();//查询数据
//		name="smartcontract01";
//		querySmartContractExts();
//		List<SmartContractExt> smartcontracts=this.apiService.querySmartContractExts(smartAddrs);
		
		
		List<SmartContractExt> smartcontracts= apiService.querySmartContractExts(allContractStr);
		model.addAttribute("smartcontracts", smartcontracts);
		return "index";
	}
	
	@RequestMapping("/loginOut")
	@ApiOperation(value="loginOut",notes="requires login Name")
	public String loginOut(Model model) {
		//shiro管理的session
		SessionUtils.clearFoundUserInfoFromSession();
		
	    return "login";  
	}

}