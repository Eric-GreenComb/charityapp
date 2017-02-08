package com.ecloudtime.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.Channel;
import com.ecloudtime.model.Contract;
import com.ecloudtime.model.Treaty;
import com.ecloudtime.model.User;
import com.ecloudtime.utils.HttpRequestUtils;

import net.sf.json.JSONObject;

@Service
public class ApiService {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //日志记录
	
	@Autowired
    private HttpService httpService;
	
	@Value("${chaincode.base.url}")
	private String ccBaseUrl;
    
    @Value("${chaincode.base.chaincodeName}")
   	private String chaincodeName;
   
    @Value("${chaincode.base.treaty01Args}")
    private String treaty01Args;
    
    @Value("${chaincode.base.user01Args}")
    private String user01Args;
    
    @Value("${chaincode.base.channel01Args}")
    private String channel01Args;
    
    @Value("${chaincode.base.fund01Args}")
    private String fund01Args;
    
    @Value("${chaincode.base.contract01Args}")
    private String contract01Args;
    
    @Value("${chaincode.base.cebbankArgs}")
    private String cebbankArgs;
    
    @Value("${chaincode.base.coinbase01_1Args}")
    private String coinbase01_1Args;
    
    @Value("${chaincode.base.coinbase01_2Args}")
    private String coinbase01_2Args;
    
    @Value("${chaincode.base.changeCoin01_1Args}")
    private String changeCoin01_1Args;
    
    @Value("${chaincode.base.changeCoin01_2Args}")
    private String changeCoin01_2Args;
    
    @Value("${chaincode.base.donate01ChannelArgs}")
    private String donate01ChannelArgs;
    
    @Value("${chaincode.base.donate01FundArgs}")
    private String donate01FundArgs;
    
    @Value("${chaincode.base.drawed01TreatArgs}")
    private String drawed01TreatArgs;
  
    @Value("${chaincode.base.drawed01ContractArgs}")
    private String drawed01ContractArgs;
	
    //查询银行done
    public Contract queryBank(@RequestParam(value="name", required=false, defaultValue="cebbank") String name){
		List<String> args=new ArrayList<String>();
		if("cebbank".equals(name)){
			args.add(cebbankArgs);
		}else{
			args.add(name);
		}
		JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryBank", args);
		Contract contract = new Contract();
		contract.setId("cebbank");
		 if(null!=jsonResponse){
			 contract.setAddr(jsonResponse.getString("addr"));
		 }
		return contract;
	}
    
    //查询用户钱包 done
    public User queryAccount(@RequestParam(value="name", required=false, defaultValue="user01") String name){
    	List<String> args=new ArrayList<String>();
		if("user01".equals(name)){
			args.add(user01Args);
		}else if("channel01".equals(name)){
			args.add(channel01Args);
		}else if("fund01".equals(name)){
			args.add(fund01Args);
		}else if("treaty01".equals(name)){
			args.add(treaty01Args);
		}else if("contract01".equals(name)){
			args.add(contract01Args);
		}else{
			args.add(name);
		}
		JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryAccount", args);
		User user = new User();
		user.setName(name);
		 if(null!=jsonResponse){
			 user.setAddr(jsonResponse.getString("addr"));
		 }
		return user;
    }
    
    public Treaty queryTreaty(@RequestParam(value="name", required=false, defaultValue="treaty01") String name){
    	Treaty treaty = new Treaty();
    	List<String> args=new ArrayList<String>();
    	if("treaty01".equals(name)){
        	args.add(treaty01Args);
        }else{
        	args.add(name);
        }
    	JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryTreaty", args);
    	if(null!=jsonResponse){
    		//填充內容
    		treaty=(Treaty)JSONObject.toBean(jsonResponse,Treaty.class);
    	}
    	return treaty;
    }
    
    public List<Treaty> queryTreaties(@RequestParam(value="name", required=false, defaultValue="treaty01") String name){
        List<Treaty> list=new ArrayList<Treaty>();
        List<String> args=new ArrayList<String>();
        if("treaty01".equals(name)){//需要对那么进行拆分
        	args.add(treaty01Args);
        }else{
        	args.add(name);
        }
        JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryTreaties", args);
        if(null!=jsonResponse){
        	this.logger.info("jsonResponse="+jsonResponse.toString());
        	Treaty treaty=(Treaty)JSONObject.toBean(jsonResponse,Treaty.class);
        	list.add(treaty);
        }
        return list;
    }
    
    public Contract queryContract(@RequestParam(value="name", required=false, defaultValue="contract01") String name){
  		List<String> args=new ArrayList<String>();
  		if("contract01".equals(name)){
  			args.add(contract01Args);
  		}else{
  			args.add(name);
  		}
  		JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryContract", args);
  		Contract contract = new Contract();
  		contract.setId("contract01");
  		 if(null!=jsonResponse){
  			 contract.setAddr(jsonResponse.getString("addr"));
  			 contract=(Contract)JSONObject.toBean(jsonResponse,Treaty.class);
  		 }
  		return contract;
  	}
    
    public List<Contract> queryContracts(@RequestParam(value="name", required=false, defaultValue="contract01") String name){
  		List<String> args=new ArrayList<String>();
  		List<Contract> list =new ArrayList<Contract>();
  		if("contract01".equals(name)){
  			args.add(contract01Args);
  		}else{
  			args.add(name);
  		}
  		JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryContract", args);
  		Contract contract =new  Contract();
  		contract.setId("contract01");
  		 if(null!=jsonResponse){
  			 contract.setAddr(jsonResponse.getString("addr"));
  			 contract=(Contract)JSONObject.toBean(jsonResponse,Treaty.class);
        	list.add(contract);
  		 }
  		return list;
  	}
    
    public User queryDonor(String name){
        List<String> args=new ArrayList<String>();
        if("user01".equals(name)){
        	args.add(user01Args);
        }else{
        	args.add(name);
        }
        JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryDonor", args);
        User user = new User();
        if(null!=jsonResponse){
        	 this.logger.info("jsonResponse="+jsonResponse.toString());
             user.setName(jsonResponse.getString("name"));
             user.setTotal(jsonResponse.getString("total"));
        }
       
        return user;
    }
    
    public void coinbase(String name){
        List<String> args=new ArrayList<String>();
        if("cebbank".equals(name)){
        	args.add(cebbankArgs);
        	args.add(coinbase01_1Args);
        	args.add(coinbase01_2Args);
        }else{
        	args.add(name);
        }
        JSONObject jsonResponse =httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "coinbase", args);
        User user = new User();
        if(null!=jsonResponse){
        	 this.logger.info("jsonResponse="+jsonResponse.toString());
             user.setName(jsonResponse.getString("name"));
             user.setTotal(jsonResponse.getString("total"));
        }
       
    }
    public void changeCoin(String name){
    	List<String> args=new ArrayList<String>();
    	if("cebbank".equals(name)){
    		args.add(cebbankArgs);
    		args.add(changeCoin01_1Args);
    		args.add(changeCoin01_2Args);
    	}else{
    		args.add(name);
    	}
    	JSONObject jsonResponse =httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "changeCoin", args);
    	User user = new User();
    	if(null!=jsonResponse){
    		this.logger.info("jsonResponse="+jsonResponse.toString());
    		user.setName(jsonResponse.getString("name"));
    		user.setTotal(jsonResponse.getString("total"));
    	}
    	
    }
    
    public String donated(@RequestParam(value="name", required=false, defaultValue="contract01") String name){
		List<String> args=new ArrayList<String>();
		String msg="error";
		args.add(channel01Args);
		args.add(user01Args);
		args.add(donate01ChannelArgs);
		args.add(donate01FundArgs);
		JSONObject jsonResponse =httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "donated", args);
		 if(null!=jsonResponse){
			 msg=jsonResponse.getString("status");
		 }
		return msg;
	}
	
    public String drawed(@RequestParam(value="name", required=false, defaultValue="contract01") String name){
		List<String> args=new ArrayList<String>();
		String msg="error";
		args.add(fund01Args);
		args.add(drawed01TreatArgs);
		args.add(drawed01ContractArgs);
		JSONObject jsonResponse =httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "drawed", args);
		 if(null!=jsonResponse){
			 msg=jsonResponse.getString("status");
		 }
		return msg;
	}
	
	
    public String destroycoinbase(@RequestParam(value="name", required=false, defaultValue="contract01") String name){
		List<String> args=new ArrayList<String>();
		String msg="error";
		if("contract01".equals(name)){
			args.add(contract01Args);
		}else{
			args.add(name);
		}
		JSONObject jsonResponse =httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "destroycoinbase", args);
		 if(null!=jsonResponse){
			 msg=jsonResponse.getString("status");
		 }
		return msg;
	}
    
    /***********************************分割线***********************************************/
    
    public Treaty viewTreaty(@RequestParam(value="name", required=false, defaultValue="contract01") String name){
    	Treaty treaty = new Treaty();
    	List<String> args=new ArrayList<String>();
    	JSONObject jsonResponse =httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryBank", args);
    	if(null!=jsonResponse){
    		//填充內容
    	}
    	return treaty;
    }
    
    

}
