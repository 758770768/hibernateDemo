package hibernateDemo.bean;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Account {
    
	private Integer aid;
	private String aName;
	private String aPass;
	private String aMess;
	
	private Set<User> us=new HashSet();
	
	public Set<User> getUs() {
		return us;
	}
	public void setUs(Set<User> us) {
		this.us = us;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPass() {
		return aPass;
	}
	public void setaPass(String aPass) {
		this.aPass = aPass;
	}
	public String getaMess() {
		return aMess;
	}
	public void setaMess(String aMess) {
		this.aMess = aMess;
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", aName=" + aName + ", aPass=" + aPass + ", aMess=" + aMess + "]";
	}
	 
 
 
	
	
	
}
