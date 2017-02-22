package com.ecloudtime.model;

import com.ecloudtime.utils.MoneyUtil;

public class SmartContract extends SmartContractGo{

	private String goalStr;//目标金额 万元
	private String goalYuan;//目标金额 元
	private String pic;
	
	public String getGoalYuan() {
		if(null!=getGoal()&&0!=getGoal()){
    		return MoneyUtil.ccToMoneyFormat(getGoal(),"yuan");
    	}
		return goalYuan;
	}

	public void setGoalYuan(String goalYuan) {
		this.goalYuan = goalYuan;
	}

	public String getGoalStr() {
		if(null!=getGoal()&&0!=getGoal()){
    		return MoneyUtil.ccToMoneyFormat(getGoal(),"wan");
    	}
    	return "0.00";
	}
	
	public String getAlreadyStr() {
		if(null!=getAlready()&&0!=getAlready()){
    		return MoneyUtil.ccToMoneyFormat(getAlready(),"wan");
    	}
		return "0";
	}
	

	public void setGoalStr(String goalStr) {
		this.goalStr = goalStr;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/*Addr                 string       `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"`
	Id                   string       `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"`
	Name                 string       `protobuf:"bytes,3,opt,name=name" json:"name,omitempty"`
	Detail               string       `protobuf:"bytes,4,opt,name=detail" json:"detail,omitempty"`
	Goal                 uint64       `protobuf:"varint,5,opt,name=goal" json:"goal,omitempty"`
	PartyA               string       `protobuf:"bytes,6,opt,name=partyA" json:"partyA,omitempty"`
	PartyB               string       `protobuf:"bytes,7,opt,name=partyB" json:"partyB,omitempty"`
	Type                 uint64       `protobuf:"varint,8,opt,name=type" json:"type,omitempty"`
	FundManangerFee      uint64       `protobuf:"varint,9,opt,name=fundManangerFee" json:"fundManangerFee,omitempty"`
	ChannelFee           uint64       `protobuf:"varint,10,opt,name=channelFee" json:"channelFee,omitempty"`
	CreateTimestamp      int64        `protobuf:"varint,11,opt,name=createTimestamp" json:"createTimestamp,omitempty"`
	UtilTimestamp        int64        `protobuf:"varint,12,opt,name=utilTimestamp" json:"utilTimestamp,omitempty"`
	TerminationTimestamp int64        `protobuf:"varint,13,opt,name=terminationTimestamp" json:"terminationTimestamp,omitempty"`
	Foundation           string       `protobuf:"bytes,14,opt,name=foundation" json:"foundation,omitempty"`
	Attachhash           string       `protobuf:"bytes,15,opt,name=attachhash" json:"attachhash,omitempty"`
	TContract            []*TContract `protobuf:"bytes,16,rep,name=tContract" json:"tContract,omitempty"`
	Status               uint64       `protobuf:"varint,17,opt,name=status" json:"status,omitempty"`
	Remark               string       `protobuf:"bytes,18,opt,name=remark" json:"remark,omitempty"`*/

}
