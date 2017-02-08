package com.ecloudtime.model;

public class Treaty {

	private String addr;
	private String id;
	private String name;
	private String detail;
	private int goal;
	private String partyA;
	private String partyB;
	private int type;
	private int fundManangerFee;
	private int channelFee;
	private int createTimestamp;
	private int utilTimestamp;
	private int terminationTimestamp;
	private String foundation;
	private String attachhash;
	private String[] tContract;
	private int status;
	private String remark;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getPartyA() {
		return partyA;
	}
	public void setPartyA(String partyA) {
		this.partyA = partyA;
	}
	public String getPartyB() {
		return partyB;
	}
	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFundManangerFee() {
		return fundManangerFee;
	}
	public void setFundManangerFee(int fundManangerFee) {
		this.fundManangerFee = fundManangerFee;
	}
	public int getChannelFee() {
		return channelFee;
	}
	public void setChannelFee(int channelFee) {
		this.channelFee = channelFee;
	}
	public int getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(int createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public int getUtilTimestamp() {
		return utilTimestamp;
	}
	public void setUtilTimestamp(int utilTimestamp) {
		this.utilTimestamp = utilTimestamp;
	}
	public int getTerminationTimestamp() {
		return terminationTimestamp;
	}
	public void setTerminationTimestamp(int terminationTimestamp) {
		this.terminationTimestamp = terminationTimestamp;
	}
	public String getFoundation() {
		return foundation;
	}
	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}
	public String getAttachhash() {
		return attachhash;
	}
	public void setAttachhash(String attachhash) {
		this.attachhash = attachhash;
	}
	public String[] gettContract() {
		return tContract;
	}
	public void settContract(String[] tContract) {
		this.tContract = tContract;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
