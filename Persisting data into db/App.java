package com.first.hibernate.a;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class App 
{
	
	@Id
    private int cid;
    private String cname;
    private int cage;
    public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	@Override
	public String toString() {
		return "App [cid=" + cid + ", cname=" + cname + ", cage=" + cage + "]";
	}
	
}
