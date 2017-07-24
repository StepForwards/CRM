package com.forward.model;

import java.sql.Timestamp;

public class Department {
	private int d_id;
	private String d_name;
	private String d_desc;
	private Timestamp d_updatetime;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_desc() {
		return d_desc;
	}
	public void setD_desc(String d_desc) {
		this.d_desc = d_desc;
	}
	public Timestamp getD_updatetime() {
		d_updatetime = new Timestamp(System.currentTimeMillis());
		return d_updatetime;
	}
	public void setD_updatetime(Timestamp d_updatetime) {
		this.d_updatetime = d_updatetime;
	}
	
	
}
