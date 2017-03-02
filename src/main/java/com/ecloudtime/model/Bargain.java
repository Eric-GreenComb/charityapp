package com.ecloudtime.model;

import com.ecloudtime.utils.DateUtil;

public class Bargain extends BargainGo{

	private String bargainStatus;
	private String bargainDate;
	
	public String getBargainDate() {
		return this.getStartTime().replace("-", ".")+"/"+this.getEndTime().replace("-", ".");
	}

	public void setBargainDate(String bargainDate) {
		this.bargainDate = bargainDate;
	}

	public String getBargainStatus() {
		DateUtil.compareThreeeDate(this.getStartTime(),this.getEndTime());
		String nowDate=DateUtil.getDay();
		if(DateUtil.compareDate(nowDate, this.getStartTime())){
			return "未开始";
		}
		if(DateUtil.compareDate(nowDate, this.getEndTime())){
			return "筹集中";
		}
		return "已失效";
	}

	public void setBargainStatus(String bargainStatus) {
		this.bargainStatus = bargainStatus;
	}
	
}
