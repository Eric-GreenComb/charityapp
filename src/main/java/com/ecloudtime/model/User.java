package com.ecloudtime.model;

import java.util.List;

import com.ecloudtime.utils.MoneyUtil;

public class User {
    private String name;
    private Integer age;
    private String password;
    private String addr;
    private String balance;
    private int total;
    private String totalStr;
    private List<DonorContribution> contributions ;

    private List<DonorTrack> trackings ;
    
    public String getTotalStr() {
    	if(0!=total){
    		return MoneyUtil.ccToMoneyFormat(total);
    	}
    	return "0.00";
	}

	public void setTotalStr(String totalStr) {
		this.totalStr = totalStr;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
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
    
    
}
