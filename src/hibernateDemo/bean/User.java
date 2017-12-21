package hibernateDemo.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
    
	 private int uid;
	 private String uName;
	 private String upass;
	 private String usex;
	 private  Set<Account> as =new HashSet();
	 
	 
	public Set<Account> getAs() {
		return as;
	}
	public void setAs(Set<Account> as) {
		this.as = as;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uName=" + uName + ", upass=" + upass + ", usex=" + usex + "]";
	}
 
	 
	 
	 
	 
 }
