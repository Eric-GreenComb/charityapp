package com.ecloudtime.model;

import java.util.List;

import com.ecloudtime.utils.DateUtil;

public class BlockInfo implements java.io.Serializable{

	private static final long serialVersionUID = -1943961352036134112L;
	
	private List<Transaction> transactions;
	
	private String stateHash;

	private String previousBlockHash;

	private String consensusMetadata;

	private NonHashData nonHashData;
	
	private String blockGenTime;
	
	public String getBlockGenTime() {
		if(null!=nonHashData){
			return DateUtil.getDateFromUnixTime(nonHashData.getLocalLedgerCommitTimestamp().getSeconds());
		}
		
		return blockGenTime;
	}

	public void setBlockGenTime(String blockGenTime) {
		this.blockGenTime = blockGenTime;
	}

	public void setStateHash(String stateHash) {
		this.stateHash = stateHash;
	}

	public String getStateHash() {
		return this.stateHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public String getPreviousBlockHash() {
		return this.previousBlockHash;
	}

	public void setConsensusMetadata(String consensusMetadata) {
		this.consensusMetadata = consensusMetadata;
	}

	public String getConsensusMetadata() {
		return this.consensusMetadata;
	}

	public void setNonHashData(NonHashData nonHashData) {
		this.nonHashData = nonHashData;
	}

	public NonHashData getNonHashData() {
		return this.nonHashData;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
