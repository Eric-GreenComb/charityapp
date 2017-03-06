package com.ecloudtime.model;

public class BlockHighGen implements java.io.Serializable{

	private static final long serialVersionUID = -1943961352036134112L;
	
	private int blockHigh;
	private String blockGenTime;
	private BlockInfo blockInfo;
	
	public BlockHighGen() {
		super();
	}
	public BlockHighGen(int blockHigh) {
		super();
		this.blockHigh = blockHigh;
	}
	public BlockHighGen(int blockHigh, String blockGenTime) {
		super();
		this.blockHigh = blockHigh;
		this.blockGenTime = blockGenTime;
	}
	public int getBlockHigh() {
		return blockHigh;
	}
	public void setBlockHigh(int blockHigh) {
		this.blockHigh = blockHigh;
	}
	public String getBlockGenTime() {
		return blockGenTime;
	}
	public void setBlockGenTime(String blockGenTime) {
		this.blockGenTime = blockGenTime;
	}
	public BlockInfo getBlockInfo() {
		return blockInfo;
	}
	public void setBlockInfo(BlockInfo blockInfo) {
		this.blockInfo = blockInfo;
	}
	
	
}
