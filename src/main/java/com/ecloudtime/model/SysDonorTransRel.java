package com.ecloudtime.model;

public class SysDonorTransRel {
	
//	INSERT INTO sys_trans_rel (trans_id, txid, block_height, tran_sign, contract_id) VALUES ('', '', '', '', '');
	private String transId;
	private String txid;
	private String blockHeight;
	private String tranSign;
	private String contractId;
	private String contractIdStr;
	private String blockHash;
	public SysDonorTransRel() {
		super();
	}
	
	public SysDonorTransRel(String transId) {
		super();
		this.transId = transId;
	}
	public SysDonorTransRel(String transId,String txid) {
		super();
		if(!"".equals(transId)){
			this.transId = transId;
		}
		if(!"".equals(txid)){
			this.txid=txid;
		}
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public String getBlockHeight() {
		return blockHeight;
	}
	public void setBlockHeight(String blockHeight) {
		this.blockHeight = blockHeight;
	}
	public String getTranSign() {
		return tranSign;
	}
	public void setTranSign(String tranSign) {
		this.tranSign = tranSign;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getBlockHash() {
		return blockHash;
	}

	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}

	public String getContractIdStr() {
		if(null!=contractId&&contractId.indexOf(":")!=-1){
			return contractId.split(":")[0];
		}
		return contractIdStr;
	}

	public void setContractIdStr(String contractIdStr) {
		this.contractIdStr = contractIdStr;
	}
	

}
