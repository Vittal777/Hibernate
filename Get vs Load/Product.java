package com.sql.sqlquery;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product 
{
	@Id
    private int pid;
    private String pname;
    private int price;
    @Embedded
    private Productprop props;
	public Productprop getProps() {
		return props;
	}
	public void setProps(Productprop props) {
		this.props = props;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
