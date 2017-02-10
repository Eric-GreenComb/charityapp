package com.ecloudtime.model;

import java.util.List;

public class DonorGo {

	private String addr;
	private String id;
	private String name;
	private Long total;

	private List<DonorContribution> contributions;// 用户捐款历史
	private List<DonorTrack> trackings;//用户的捐款追踪 

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

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<DonorContribution> getContributions() {
		return contributions;
	}

	public void setContributions(List<DonorContribution> contributions) {
		this.contributions = contributions;
	}

	public List<DonorTrack> getTrackings() {
		return trackings;
	}

	public void setTrackings(List<DonorTrack> trackings) {
		this.trackings = trackings;
	}

	/*
	 * Addr string `protobuf:"bytes,1,opt,name=addr" json:"addr,omitempty"` Id
	 * string `protobuf:"bytes,2,opt,name=id" json:"id,omitempty"` Name string
	 * `protobuf:"bytes,3,opt,name=name" json:"name,omitempty"` Total uint64
	 * `protobuf:"varint,4,opt,name=total" json:"total,omitempty"` Contributions
	 * []*DonorContribution `protobuf:"bytes,5,rep,name=contributions"
	 * json:"contributions,omitempty"` Trackings []*DonorTrack
	 * `protobuf:"bytes,6,rep,name=trackings" json:"trackings,omitempty"`
	 */
}
