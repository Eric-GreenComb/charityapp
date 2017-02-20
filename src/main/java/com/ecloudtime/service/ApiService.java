package com.ecloudtime.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecloudtime.model.Account;
import com.ecloudtime.model.Channel;
import com.ecloudtime.model.Contract;
import com.ecloudtime.model.DonorContribution;
import com.ecloudtime.model.DonorTrack;
import com.ecloudtime.model.Foundation;
import com.ecloudtime.model.ProcessDonored;
import com.ecloudtime.model.ProcessDrawed;
import com.ecloudtime.model.SmartContract;
import com.ecloudtime.model.SmartContractExt;
import com.ecloudtime.model.SmartContractTrack;
import com.ecloudtime.model.TX;
import com.ecloudtime.model.TX_TXIN;
import com.ecloudtime.model.TX_TXOUT;
import com.ecloudtime.model.User;
import com.ecloudtime.utils.Base64Util;
import com.ecloudtime.utils.DateUtil;
import com.ecloudtime.utils.HttpRequestUtils;
import com.ecloudtime.utils.MoneyUtil;
import com.ecloudtime.utils.RSASignatureUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ApiService {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

	@Autowired
	private HttpService httpService;
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CacheManager cacheManager;

	@Value("${chaincode.base.url}")
	private String ccBaseUrl;
	
	@Value("${chaincode.base.chaincodeName}")
	private String chaincodeName;

	@Value("${chaincode.base.txversion}")
	private int txversion;
	
	@Value("${chaincode.base.smartcontract01Args}")
	private String smartcontract01Args;
	
	@Value("${chaincode.base.bargain01Args}")
	private String bargain01Args;

	@Value("${chaincode.base.donor01Args}")
	private String donor01Args;

	@Value("${chaincode.base.channel01Args}")
	private String channel01Args;

	@Value("${chaincode.base.fund01Args}")
	private String fund01Args;

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

	public void init(){
		//1.invoke RegisterBank
		List<String> args = new ArrayList<String>();
		args.add("cebbank:29731d0e6c6ca9cb985eabf9fe716d1644c624cae5265c36c9b7a46702003924");
		args.add("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FDenFYaVVyRFZzanhIZzdyM1RMc1NSaGlaTApqeE1nczBIU3JsRlV3c0s1eFVCcGFwSHdSazlHeGJrMWtOd2tkSzdPeHlselJjbmxzbEd5VnhhU21KYzNqbmpvClVRVFphbVRaemViMzNNZC9oYUVkN3BhSXFkSS9pZ1Z6TEtpaStXcFJkUE02VlFaV0pHam01eEMwMHhWUWw3aWcKOExBUXV6ek1OMnNCRkhsSmN3SURBUUFCCi0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQo=");
		args.add("QPssbLyWzxZKd2ib//dZpBq0CVXGUuujnTkpMp+rsCPUqTvvwTvhrPomwaeMZagQzBzPiltKdrHZ5RiLqEGOFWsB4PJLNrAKRnVme1cHhpZ0Qwi1TP/HYgSflW5sSZ3FUM9pm75G9FuPkQpmO0bnkG1X5GKLWr3n2XRDcAlkPVg=");
		httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "registerBank", args);
		//2.invoke RegisterFund
		args = new ArrayList<String>();
		args.add("fund01:25ab580a2093776ca2e1dd1775e96dfec5f1ffbcc9565129351cb330cf0712d7");
		args.add("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FEanZlcE94YkI1SGlQbVgwcnJTUThJMG90MQp2c0ljNno0RThtVnhubEtlMCt3MVpOT1J1UEdwSmE1TENNZWNqNDk4dllDcEljbk1IMkJCZjJQMk4wcnVkOW5PCllOVWZiOHlxdk5aODZNNHZBRVM4d2QxT1MzYmY1bm12Ry92Ykl5aWQwSmdIK0tRNU1LVDFZSjNGRE5TcWYrbHQKRHVTOWFUeDhtb3BKODlSME93SURBUUFCCi0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQo=");
		args.add("SKzK1DsdKfHMEljNPV9mtFAQfDwld2Q3cwB/yhR6wnXoZlTKpi5PPLRL+ZIYDiJgYm3rRTOmjnWA+XAjQyhKL1BukUM/l/VLBVApcLhYlM8iqhattDEOsUraEzk2RXO6hlr+bljaR4JEqW2+FdCp23eoiSdjNum6HeA/UIOedwE=");
		httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "registerFund", args);
		//2.invoke RegisterFund
		args = new ArrayList<String>();
		args.add("channel01:9c8b43ce948010efc3b7d102aae502165ccd5e0714a3e765fe1a8f444936785a");
		args.add("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FERGVNNzJVRnkvK1VTaUpTU3BkWlF2Tmt2NgpySDAvQ25raUJMRmRBUEVIUUR6bTY0Wks3bWR0bUE2ayt1alJtbENXbjhIUVRSK0xHcGp4WGxhVFc1a1Z2a2xVCks4cUdkRUUzNW5JTW0zQnc2ZldsQUlvV2I4dUxEQjlVQmpIVGxIb1dlaEE0SzV3WEh6ZmpqaWQ0U2dBNEhwbzUKdlhlazdzc3RESEpBZUhuNXdRSURBUUFCCi0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQo=");
		args.add("jYpb/0yeO8TZ6fMPezgr4c4eRG9heObZcFVG/nRk1YSaDrW5Y2d9yaPSsjOc5p3OurFWJOQvC2xL1A0RstsPNKpIqjiickLZ/HqLXDr/4NrK4VZT2yeGwHU+nYasntaRDMwHhj1JD/zdC3sGxt8a/zQmoPmNybS7bZ0JM5vc+sQ=");
		httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "registerFund", args);
		
	}
	
	// 查询银行done
	public Contract queryBank(@RequestParam(value = "name", required = false, defaultValue = "cebbank") String name) {
		List<String> args = new ArrayList<String>();
		if ("cebbank".equals(name)) {
			args.add(cebbankArgs);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryBank", args);
		Contract contract = new Contract();
		contract.setId("cebbank");
		if (null != jsonResponse) {
			contract.setAddr(jsonResponse.getString("addr"));
		}
		return contract;
	}

	// 查询用户钱包 done
	public Account queryAccount(@RequestParam(value = "name", required = false, defaultValue = "donor01") String name) {
		List<String> args = new ArrayList<String>();
		if ("donor01".equals(name)) {
			args.add(donor01Args);
		} else if ("channel01".equals(name)) {
			args.add(channel01Args);
		} else if ("fund01".equals(name)) {
			args.add(fund01Args);
		} else if ("smartcontract01".equals(name)) {
			args.add(smartcontract01Args);
		} else if ("bargain01".equals(name)) {
			args.add(bargain01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryAccount",
				args);
		Account account = new Account();
		
		if (null != jsonResponse) {
			this.logger.info("jsonResponse=" + jsonResponse.toString());
			Map<String, Class> classMap = new HashMap<String, Class>();
//			classMap.put("txouts", TX_TXOUT.class);
			account = (Account) JSONObject.toBean(jsonResponse, Account.class, classMap);
			Map<String,TX_TXOUT> txouts=new HashMap<String,TX_TXOUT>();
			JSONObject txoutsJson=jsonResponse.getJSONObject("txouts");
			
			if(!txoutsJson.isEmpty()){
				for (Iterator<String> keys = txoutsJson.keys(); keys.hasNext();) { 
					 String key1 = keys.next();  
					 TX_TXOUT txout=(TX_TXOUT)JSONObject.toBean((JSONObject)txoutsJson.get(key1), TX_TXOUT.class);
					 txouts.put(key1, txout);
				} 
				account.setTxouts(txouts);
			}
			
			
			
			
		}
		return account;
	}

	/**
	 * 查询智能合约
	 * @param name
	 * @return
	 * 
{
  "jsonrpc": "2.0",
  "result": {
    "status": "OK",
    "message": "{\"addr\":\"smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8\",\"name\":\"宁夏西部地区母亲水窖项目\",\"detail\":\"宁夏西部地区母亲水窖项目\",\"goal\":1000000000000,\"partyA\":\"某基金会\",\"partyB\":\"某地区\",\"fundAddr\":\"fund01:25ab580a2093776ca2e1dd1775e96dfec5f1ffbcc9565129351cb330cf0712d7\",\"fundName\":\"某基金会\",\"fundManangerFee\":3,\"channelAddr\":\"channel01:9c8b43ce948010efc3b7d102aae502165ccd5e0714a3e765fe1a8f444936785a\",\"channelName\":\"某ChannelName\",\"channelFee\":2,\"createTimestamp\":1487239596,\"foundation\":\"fund01:25ab580a2093776ca2e1dd1775e96dfec5f1ffbcc9565129351cb330cf0712d7\"}"
  },
  "id": 5
}
	 */
	public SmartContract querySmartContract(@RequestParam(value = "name", required = false, defaultValue = "smartcontract01") String name) {
		SmartContract smartContract = new SmartContract();
		List<String> args = new ArrayList<String>();
		if ("smartcontract01".equals(name)) {
			args.add(smartcontract01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "querySmartContract", args);
		if (null != jsonResponse) {
			// 填充內容
			smartContract = (SmartContract) JSONObject.toBean(jsonResponse, SmartContract.class);
		}
		return smartContract;
	}
	
	
	/**
	 * 
	 * @param name
	 * @return
{
  "jsonrpc": "2.0",
  "result": {
    "status": "OK",
    "message": "{\"donorUUID\":\"15F332E9906ED10294CC634747ADD787\",\"donorAddr\":\"donor01:275e74b0e340f54135496e46d829b25af699984e6787f9a7b13191ad991a1eb1\",\"smartContractAddr\":\"smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8\",\"smartContractName\":\"宁夏西部地区母亲水窖项目\",\"fundName\":\"某基金会\",\"channelName\":\"某ChannelName\",\"amount\":100000000,\"smartContractAmount\":99500000,\"channelAmount\":200000,\"fundAmount\":300000,\"timestamp\":1487314150,\"remark\":\"15F332E9906ED10294CC634747ADD787\"}"
  },
  "id": 5
}
	 */
	public ProcessDonored queryProcessDonored(@RequestParam(value = "name", required = false, defaultValue = "smartcontract01") String name) {
		ProcessDonored processDonored = new ProcessDonored();
		List<String> args = new ArrayList<String>();
		args.add(name);
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryProcessDonored", args);
		if (null != jsonResponse) {
			// 填充內容
			processDonored = (ProcessDonored) JSONObject.toBean(jsonResponse, ProcessDonored.class);
		}
		return processDonored;
	}
	
	public ProcessDrawed queryProcessDrawed(@RequestParam(value = "name", required = false, defaultValue = "smartcontract01") String name) {
		ProcessDrawed processDrawed = new ProcessDrawed();
		List<String> args = new ArrayList<String>();
		args.add(name);
		/*if ("smartcontract01".equals(name)) {
			args.add(smartcontract01Args);
		} else {
		}*/
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryProcessDrawed", args);
		if (null != jsonResponse) {
			// 填充內容
			processDrawed = (ProcessDrawed) JSONObject.toBean(jsonResponse, ProcessDrawed.class);
		}
		return processDrawed;
	}
	
	
	/**
	 * 
	 * @param name
	 * @return
{
  "jsonrpc": "2.0",
  "result": {
    "status": "OK",
    "message": "{\"addr\":\"smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8\"}"
  },
  "id": 5
}
	 */
	public SmartContractTrack querySmartContractTrack(@RequestParam(value = "name", required = false, defaultValue = "smartcontract01") String name) {
		SmartContractTrack smartContractTrack = new SmartContractTrack();
		List<String> args = new ArrayList<String>();
		if ("smartcontract01".equals(name)) {
			args.add(smartcontract01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "querySmartContractTrack", args);
		if (null != jsonResponse) {
			// 填充內容
			smartContractTrack = (SmartContractTrack) JSONObject.toBean(jsonResponse, SmartContractTrack.class);
		}
		return smartContractTrack;
	}
	
	/**
	 * 查询基金 详情
	 * @param name
	 * @return
{
  "jsonrpc": "2.0",
  "result": {
    "status": "OK",
    "message": "{\"addr\":\"fund01:25ab580a2093776ca2e1dd1775e96dfec5f1ffbcc9565129351cb330cf0712d7\",\"total\":100000000,\"validTotal\":99500000}"
  },
  "id": 5
}
	 */
	public Foundation queryFund(@RequestParam(value = "name", required = false, defaultValue = "fund01") String name) {
		Foundation fund = new Foundation();
		List<String> args = new ArrayList<String>();
		if ("fund01".equals(name)) {
			args.add(fund01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryFund", args);
		if (null != jsonResponse) {
			// 填充內容
			fund = (Foundation) JSONObject.toBean(jsonResponse, Foundation.class);
		}
		return fund;
	}
	
	/**
	 * 查询渠道信息
	 * @param name
	 * @return
{
  "jsonrpc": "2.0",
  "result": {
    "status": "OK",
    "message": "{\"addr\":\"channel01:9c8b43ce948010efc3b7d102aae502165ccd5e0714a3e765fe1a8f444936785a\",\"total\":200000}"
  },
  "id": 5
}
	 */
	public Channel queryChannel(@RequestParam(value = "name", required = false, defaultValue = "channel01") String name) {
		Channel channel = new Channel();
		List<String> args = new ArrayList<String>();
		if ("channel01".equals(name)) {
			args.add(channel01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryChannel", args);
		if (null != jsonResponse) {
			// 填充內容
			channel = (Channel) JSONObject.toBean(jsonResponse, Channel.class);
		}
		return channel;
	}

	//查询首页的 合约信息表
	public List<SmartContractExt> querySmartContractExts(String smartAddrs){
		List<SmartContractExt> list = new ArrayList<SmartContractExt>();
		List<String> args = new ArrayList<String>();
	    args.add(smartAddrs);
		JSONArray jsonResponse = (JSONArray) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "querySmartContractExts", args);
		if (null != jsonResponse) {
			Iterator<Object> it = jsonResponse.iterator();
			while (it.hasNext()) {
				JSONObject ob = (JSONObject) it.next();
				this.logger.info("ob=" + ob.toString());
				SmartContractExt smartContractExt = (SmartContractExt) JSONObject.toBean(ob, SmartContractExt.class);
					SmartContract smartContract = new SmartContract();
					smartContract.setAddr(smartContractExt.getAddr());
					smartContract=commonService.findContractInfo(smartContract);
				smartContractExt.setPic(smartContract.getPic());
				list.add(smartContractExt);
			}
		}
		return list;
	}
	
	public List<SmartContract> querySmartContracts(
			@RequestParam(value = "name", required = false, defaultValue = "smartcontract01") String name) {
		List<SmartContract> list = new ArrayList<SmartContract>();
		List<String> args = new ArrayList<String>();
		if ("smartcontract01".equals(name)) {// 需要对那么进行拆分
			args.add(smartcontract01Args);
		} else {
			args.add(name);
		}
		JSONArray jsonResponse = (JSONArray) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "querySmartContracts", args);
		if (null != jsonResponse) {
			Iterator<Object> it = jsonResponse.iterator();
			while (it.hasNext()) {
				JSONObject ob = (JSONObject) it.next();
				this.logger.info("ob=" + ob.toString());
				SmartContract treaty = (SmartContract) JSONObject.toBean(ob, SmartContract.class);
				list.add(treaty);
			}
		}
		return list;
	}

	public Contract queryContract(
			@RequestParam(value = "name", required = false, defaultValue = "bargain01") String name) {
		List<String> args = new ArrayList<String>();
		if ("bargain01".equals(name)) {
			args.add(bargain01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject)httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryContract", args);
		Contract contract = new Contract();
		contract.setId("contract01");
		if (null != jsonResponse) {
			contract.setAddr(jsonResponse.getString("addr"));
			contract = (Contract) JSONObject.toBean(jsonResponse, SmartContract.class);
		}
		return contract;
	}

	public List<Contract> queryContracts(
			@RequestParam(value = "name", required = false, defaultValue = "bargain01") String name) {
		List<String> args = new ArrayList<String>();
		List<Contract> list = new ArrayList<Contract>();
		if ("bargain01".equals(name)) {
			args.add(bargain01Args);
		} else {
			args.add(name);
		}
		JSONArray jsonResponse = (JSONArray)httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryContract", args);
		if (null != jsonResponse) {
			Iterator<Object> it = jsonResponse.iterator();
			while (it.hasNext()) {
				JSONObject ob = (JSONObject) it.next();
				this.logger.info("ob=" + ob.toString());
				Contract contract = (Contract) JSONObject.toBean(ob, Contract.class);
				list.add(contract);
			}
		}
		return list;
	}

	/**
	 * 
	 * @param name
	 * @return
{
  "jsonrpc": "2.0",
  "result": {
    "status": "OK",
    "message": "{\"addr\":\"donor01:275e74b0e340f54135496e46d829b25af699984e6787f9a7b13191ad991a1eb1\",\"contributions\":[{\"donorid\":\"15F332E9906ED10294CC634747ADD787\",\"smartContractName\":\"宁夏西部地区母亲水窖项目\",\"smartContractAddr\":\"smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8\",\"amount\":100000000,\"timestamp\":1487314150}],\"trackings\":[{\"donorid\":\"15F332E9906ED10294CC634747ADD787\",\"accountAddr\":\"smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8\",\"amount\":99500000,\"donorAmount\":100000000,\"timestamp\":1487314150},{\"donorid\":\"15F332E9906ED10294CC634747ADD787\",\"accountAddr\":\"channel01:9c8b43ce948010efc3b7d102aae502165ccd5e0714a3e765fe1a8f444936785a\",\"amount\":200000,\"donorAmount\":100000000,\"type\":2,\"timestamp\":1487314150},{\"donorid\":\"15F332E9906ED10294CC634747ADD787\",\"accountAddr\":\"fund01:25ab580a2093776ca2e1dd1775e96dfec5f1ffbcc9565129351cb330cf0712d7\",\"amount\":300000,\"donorAmount\":100000000,\"type\":3,\"timestamp\":1487314150}]}"
  },
  "id": 5
}
	 */
	public User queryDonor(String name) {
		List<String> args = new ArrayList<String>();
		if ("donor01".equals(name)) {
			args.add(donor01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject)httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryDonor", args);
		User user = new User();
		if (null != jsonResponse) {
			this.logger.info("jsonResponse=" + jsonResponse.toString());
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("contributions", DonorContribution.class);
			classMap.put("trackings", DonorTrack.class);
			user = (User) JSONObject.toBean(jsonResponse, User.class, classMap);
		}

		return user;
	}

	public void coinbase(String name) {
		List<String> args = new ArrayList<String>();
		if ("cebbank".equals(name)) {
			args.add(cebbankArgs);
			args.add(coinbase01_1Args);
			args.add(coinbase01_2Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "coinbase", args);
		User user = new User();
		if (null != jsonResponse) {
			this.logger.info("jsonResponse=" + jsonResponse.toString());
			user.setName(jsonResponse.getString("name"));
			user.setTotal(jsonResponse.getInt("total"));
		}
	}

	public void changeCoin(String name) {
		List<String> args = new ArrayList<String>();
		if ("cebbank".equals(name)) {
			args.add(cebbankArgs);
			args.add(changeCoin01_1Args);
			args.add(changeCoin01_2Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "changeCoin", args);
		User user = new User();
		if (null != jsonResponse) {
			this.logger.info("jsonResponse=" + jsonResponse.toString());
			user.setName(jsonResponse.getString("name"));
			user.setTotal(jsonResponse.getInt("total"));
		}
	}
	
	public String changeCoin(String cebAddr,String tx,String cebSign){
		List<String> args = new ArrayList<String>();
		args.add(cebAddr);
		args.add(tx);
		args.add(cebSign);
		String msgId = (String)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "changeCoin", args);
		return msgId;
	}

	public String donated(@RequestParam(value = "name", required = false, defaultValue = "contract01") String name) {
		List<String> args = new ArrayList<String>();
		String msg = "error";
		args.add(channel01Args);
		args.add(donor01Args);
		args.add(donate01ChannelArgs);
		args.add(donate01FundArgs);
		JSONObject jsonResponse = (JSONObject)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "donated", args);
		if (null != jsonResponse) {
			msg = jsonResponse.getString("status");
		}
		return msg;
	}
	/**
	 * 
	 * 
	 * @param donorName
	 * @param donorAmount
	 * @return
 _sourceAddr := args[0]     //donorAddr
_donorAddr := args[1]         //donorAddr
_donorUUID := args[2]         //donorUUID
_smartContractAddr := args[3] //smartContractAddr 合约地址
_base64TxData := args[4]      //tx --》json————》base64
_base64SourcSign := args[5]   // 用donor的私钥签名
	 */
	public String donated(String donorName,String donorAmount) {
		
		String msg = "error";
		String smartContractName="smartcontract01";//捐款合约 限定
		String cebBankAddr=cebbankArgs;//中央银行
		String donorAddr=this.commonService.findDonorAddrByName(donorName);
		if(StringUtils.isEmpty(donorAddr))return "";
		String donorUUID=this.commonService.getDonorUuid();//生成的捐款id
		String smartContractAddr=this.commonService.findSmartContractAddrByName(smartContractName);
		//1.捐款时,先查询银行的钱数
		String cebBangTx=Base64Util.getBase64(getCebBankTx(donorUUID,donorAddr,donorAmount));
		//2.换币
		String cebSign="";
		try {
			cebSign = RSASignatureUtil.signWithKeyPath(cebBangTx, "cebBank");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String messageIdChange=this.changeCoin(cebBankAddr, cebBangTx, cebSign);
		//
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//3.拼接donorTx
		String donorTx=Base64Util.getBase64(getDonorTx(donorUUID,donorAddr,donorAmount,smartContractAddr));
		
		//4.捐款
		 /*_sourceAddr := args[0]     //donorAddr
					_donorAddr := args[1]         //donorAddr
					_donorUUID := args[2]         //donorUUID
					_smartContractAddr := args[3] //合约地址
					_base64TxData := args[4]      //tx --》json————》base64
					_base64SourcSign := args[5]   // 用donor的私钥签名
		  	*/		
		String donorSign="";
		try {
			donorSign=RSASignatureUtil.signWithKeyPath(donorAddr+donorUUID+smartContractAddr+donorTx, "donor");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> args = new ArrayList<String>();
		args.add(donorAddr);//args[0]     //donorAddr
		args.add(donorAddr);//args[1]         //donorAddr
		args.add(donorUUID);//args[2]         //donorUUID
		args.add(smartContractAddr);//args[3] //合约地址
		args.add(donorTx);// args[4]      //tx --》json————》base64
		args.add(donorSign);// args[5]   // 用donor的私钥签名
			msg = (String)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "donated", args);
		return msg;
	}
	
	/**
	 * @param donorUUID
	 * @param donorName
	 * @param donorAmount
	 * @return
	 */
	public String getDonorTx(String donorUUID,String donorAddr,String donorAmount,String smartContractAddr){
		Account donorAccount =this.queryAccount(donorAddr);
		Map<String, TX_TXOUT> txouts=donorAccount.getTxouts();
		double donorMoneyCC=MoneyUtil.moneyToCcFormat(donorAmount);
		long  cebBankMoney=0;
		TX_TXOUT txout=new TX_TXOUT();
		String sourceTxHash="";
		  for (String key : txouts.keySet()) {
			  txout=(TX_TXOUT)txouts.get(key);
			  if((donorAddr+","+donorUUID).equals(txout.getAttr())){
				  sourceTxHash=key;
				  cebBankMoney=txout.getValue();
				  break;
			  }
		  }
		  if(StringUtils.isEmpty(sourceTxHash))return "";
		  //获取txin  输入信息
		  TX_TXIN txin= new TX_TXIN();
		  txin.setAddr(donorAddr);
		  txin.setSourceTxHash(sourceTxHash.split(":")[0]);
		  List<TX_TXIN> txinList = new ArrayList<TX_TXIN>();
		  try {
				txin.setIdx(Integer.parseInt(sourceTxHash.split(":")[1]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				txin.setIdx(0);
			}
		  txinList.add(txin);
		  //捐献给 合约
		  TX_TXOUT txoutDonor = new TX_TXOUT();
		  txoutDonor.setAddr(smartContractAddr);
		  txoutDonor.setValue(Math.round(MoneyUtil.moneyToCcFormat(donorAmount)));//捐款之后剩下的余额
		  txoutDonor.setAttr(donorAddr+","+donorUUID);
		  List<TX_TXOUT> txoutList = new ArrayList<TX_TXOUT>();
		  txoutList.add(txoutDonor);
		  TX tx = new TX();
		  tx.setFounder(smartContractAddr);
		  tx.setVersion(txversion);
		  tx.setTimestamp(DateUtil.getUnixTime());
		  tx.setTxin(txinList);
		  tx.setTxout(txoutList);
		 return JSONObject.fromObject(tx).toString();
	}
	
	public String getCebBankTx(String donorUuid,String donorAddr,String donorAmount){
		String cebBankAddr=cebbankArgs;//
		Account cebBank =this.queryAccount(cebbankArgs);
		Map<String,TX_TXOUT> txouts=cebBank.getTxouts();
		long donorMoneyCC=MoneyUtil.moneyToCcFormat(donorAmount);
		long  cebBankMoney=0;
		String sourceTxHash="";
		TX_TXOUT txout= new TX_TXOUT();
		  for (String key : txouts.keySet()) {
//		   System.out.println("key= "+ key + " and value= " + txouts.get(key));
			  txout=txouts.get(key);
			  if(donorMoneyCC<txout.getValue()){//捐款金额 小于银行中的数据即可
				  sourceTxHash=key;
				  cebBankMoney=txout.getValue();
				  break;
			  }
		  }
		  TX_TXIN txin= new TX_TXIN();
		  txin.setAddr(cebBankAddr);
		  txin.setSourceTxHash(sourceTxHash.split(":")[0]);
		  try {
				txin.setIdx(Integer.parseInt(sourceTxHash.split(":")[1]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				txin.setIdx(0);
			}
		  List<TX_TXIN> txinList = new ArrayList<TX_TXIN>();
		  txinList.add(txin);
		
		  TX_TXOUT txoutBank = new TX_TXOUT();
		  txoutBank.setAddr(cebBankAddr);
		  txoutBank.setValue(cebBankMoney-Math.round(donorMoneyCC));//捐款之后剩下的余额
		  TX_TXOUT txoutDonor = new TX_TXOUT();
		  txoutDonor.setAddr(donorAddr);
		  txoutDonor.setValue(Math.round(donorMoneyCC));//捐款之后剩下的余额
//		  donorUuid
		  txoutDonor.setAttr(donorAddr+","+donorUuid);
		  List<TX_TXOUT> txoutList = new ArrayList<TX_TXOUT>();
		  txoutList.add(txoutBank);
		  txoutList.add(txoutDonor);
			/*private long value;//银行的钱找零的数据值
			private String addr;//银行的addresss
			private String attr;// donorAddr +","+ donorUuid
			private String sign; //为空*/
		  TX tx = new TX();
		  tx.setVersion(txversion);
		  tx.setTimestamp(DateUtil.getUnixTime());
		  tx.setFounder(cebBankAddr);
		  tx.setTxin(txinList);
		  tx.setTxout(txoutList);
		 /* private long version;
			private long timestamp;
			private String inputData;//这个原型 go中是 name=inputData" json:"InputData,omitempty  有可能会出现问题
			private String founder;
			private List<TX_TXIN> txin;
			private List<TX_TXOUT> txout;*/
		  
		  
		  return JSONObject.fromObject(tx).toString();
	}
	
	

	public String drawed(@RequestParam(value = "name", required = false, defaultValue = "contract01") String name) {
		List<String> args = new ArrayList<String>();
		String msg = "error";
		args.add(fund01Args);
		args.add(drawed01TreatArgs);
		args.add(drawed01ContractArgs);
		JSONObject jsonResponse = (JSONObject)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "drawed", args);
		if (null != jsonResponse) {
			msg = jsonResponse.getString("status");
		}
		return msg;
	}

	public String destroycoinbase(
			@RequestParam(value = "name", required = false, defaultValue = "bargain01") String name) {
		List<String> args = new ArrayList<String>();
		String msg = "error";
		if ("bargain01".equals(name)) {
			args.add(bargain01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject)httpService.httpPostInvoke(ccBaseUrl, chaincodeName, "destroycoinbase", args);
		if (null != jsonResponse) {
			msg = jsonResponse.getString("status");
		}
		return msg;
	}
	
	
	public void queryDonorDeatail(String donorid){
		
	}
	

	/*public Treaty queryTreaty(@RequestParam(value = "name", required = false, defaultValue = "treaty01") String name) {
		Treaty treaty = new Treaty();
		List<String> args = new ArrayList<String>();
		if ("treaty01".equals(name)) {
			args.add(treaty01Args);
		} else {
			args.add(name);
		}
		JSONObject jsonResponse = (JSONObject) httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryTreaty", args);
		if (null != jsonResponse) {
			// 填充內容
			treaty = (Treaty) JSONObject.toBean(jsonResponse, Treaty.class);
		}
		return treaty;
	}*/
	
	
	/*********************************** 分割线 ***********************************************/

	public SmartContract viewTreaty(@RequestParam(value = "name", required = false, defaultValue = "contract01") String name) {
		SmartContract treaty = new SmartContract();
		List<String> args = new ArrayList<String>();
		JSONObject jsonResponse = (JSONObject)httpService.httpPostQuery(ccBaseUrl, chaincodeName, "queryBank", args);
		if (null != jsonResponse) {
			// 填充內容
			
		}
		return treaty;
	}

}
