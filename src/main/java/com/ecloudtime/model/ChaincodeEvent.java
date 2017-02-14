package com.ecloudtime.model;

public class ChaincodeEvent implements java.io.Serializable{
	private static final long serialVersionUID = -1943961352036134112L;
	private String id;
	private String name ;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}