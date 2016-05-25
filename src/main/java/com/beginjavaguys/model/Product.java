package com.beginjavaguys.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column
	//@GeneratedValue(strategy=GenerationType.AUTO)
private int pid;
	@Column
private String pname;
	@Column
private int cost;
	@Column
private int qty;


public Product(){}

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
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}



}
