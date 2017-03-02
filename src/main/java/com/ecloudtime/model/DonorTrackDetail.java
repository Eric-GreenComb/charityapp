package com.ecloudtime.model;

import java.util.ArrayList;
import java.util.List;

import com.ecloudtime.utils.MoneyUtil;

public class DonorTrackDetail {
	
	private String donorid;
	private String drawid;
	private long donorAmount;//发起捐款
	private String donorAmountStr;
	private long channelAmount;//渠道账户
	private String channelAmountStr;
	private long fundAmount;//基金管理账户
	private String fundAmountStr;
	private long contractAmount;//基金管理账户
	private String contractAmountStr;
	
	private List<DonorTrack> drawList=new ArrayList<DonorTrack>();
	
	
	public DonorTrackDetail() {
		super();
	}
	//donate :0    draw :1  channel:2   fund:3
	public DonorTrackDetail(List<DonorTrack> dclist) {
		super();
		for(DonorTrack dt :dclist){
			if("0".equals(dt.getType())){
				this.setDonorAmount(dt.getDonorAmount());
				this.setContractAmount(dt.getAmount());
				this.setDonorid(dt.getDonorid());
//				this.drawList.add(dt);
			}else if("1".equals(dt.getType())){
				this.setDrawid(dt.getDrawid());
				if(this.drawList.size()<3)
				this.drawList.add(dt);
			}else if("2".equals(dt.getType())){
				this.setChannelAmount(dt.getAmount());
//				this.drawList.add(dt);
			}else if("3".equals(dt.getType())){
				this.setFundAmount(dt.getAmount());
			}
		}
	}
	

	public List<DonorTrack> getDrawList() {
		return drawList;
	}

	public void setDrawList(List<DonorTrack> drawList) {
		this.drawList = drawList;
	}

	public String getDonorid() {
		return donorid;
	}

	public void setDonorid(String donorid) {
		this.donorid = donorid;
	}

	public String getDrawid() {
		return drawid;
	}

	public void setDrawid(String drawid) {
		this.drawid = drawid;
	}

	public long getDonorAmount() {
		return donorAmount;
	}

	public void setDonorAmount(long donorAmount) {
		this.donorAmount = donorAmount;
	}

	public String getDonorAmountStr() {
		if(0!=getDonorAmount()){
    		return MoneyUtil.ccToMoneyFormat(getDonorAmount(),"yuan");
    	}
		return donorAmountStr;
	}

	public void setDonorAmountStr(String donorAmountStr) {
		this.donorAmountStr = donorAmountStr;
	}

	public long getChannelAmount() {
		return channelAmount;
	}

	public void setChannelAmount(long channelAmount) {
		this.channelAmount = channelAmount;
	}

	public String getChannelAmountStr() {
		if(0!=getChannelAmount()){
    		return MoneyUtil.ccToMoneyFormat(getChannelAmount(),"yuan");
    	}
		
		return channelAmountStr;
	}

	public void setChannelAmountStr(String channelAmountStr) {
		this.channelAmountStr = channelAmountStr;
	}

	public long getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(long fundAmount) {
		this.fundAmount = fundAmount;
	}

	public String getFundAmountStr() {
		if(0!=getFundAmount()){
    		return MoneyUtil.ccToMoneyFormat(getFundAmount(),"yuan");
    	}
		
		return fundAmountStr;
	}

	public void setFundAmountStr(String fundAmountStr) {
		this.fundAmountStr = fundAmountStr;
	}

	public long getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(long contractAmount) {
		this.contractAmount = contractAmount;
	}

	public String getContractAmountStr() {
		if(0!=getContractAmount()){
    		return MoneyUtil.ccToMoneyFormat(getContractAmount(),"yuan");
    	}
		return contractAmountStr;
	}

	public void setContractAmountStr(String contractAmountStr) {
		this.contractAmountStr = contractAmountStr;
	}
	

}
