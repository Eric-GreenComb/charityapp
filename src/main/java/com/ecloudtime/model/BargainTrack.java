package com.ecloudtime.model;

import java.util.ArrayList;
import java.util.List;

import com.ecloudtime.utils.MoneyUtil;

public class BargainTrack {

	private String addr;
	private String totalStr;
	private List<BargainHistory> trans = new ArrayList<BargainHistory>();
	
	public String getTotalStr() {
		if(null!=trans&&trans.size()>0){
			long total=0;
			for(BargainHistory his:trans){
				total+=his.getAmount();
			}
			if(0!=total){
	    		return MoneyUtil.ccToMoneyFormat(total,"yuan");
	    	}
		}
		
		return totalStr;
	}
	public void setTotalStr(String totalStr) {
		this.totalStr = totalStr;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<BargainHistory> getTrans() {
		return trans;
	}
	public void setTrans(List<BargainHistory> trans) {
		this.trans = trans;
	}
	
	/*,
    "message": "{\"addr\":\"bargain01:8fcc58ea7ed212f7c1ba359d15bea144e67c390044d953797548cf67fd62534a\",\
    "trans\":[{\"amount\":10000000,\"timestamp\":1487820879}]
	 */
	
}
