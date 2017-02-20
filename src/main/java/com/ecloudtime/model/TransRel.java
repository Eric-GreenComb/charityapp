package com.ecloudtime.model;

public class TransRel {

	private String transId;
	private String txid;
	private String blockHeight;
	private String tranSign;
	private String contractId;
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
	
	/*CREATE TABLE
    sys_trans_rel
    (
        trans_id VARCHAR(100),
        txid VARCHAR(100),
        block_height VARCHAR(10),
        tran_sign VARCHAR(200),
        contract_id VARCHAR(100)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易跟区块链 txid的对应关系和对应区块的高度，需要记录';*/
}
