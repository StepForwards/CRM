package com.forward.model;

import java.sql.Timestamp;

public class Mail {
	private int m_id;
	private int m_sendid;
	private int m_receiveid;
	private String m_theme;
	private String m_content;
	private Timestamp m_sendtime;
	private int m_sendstatus;
	private int m_receivestatus;
	private String r_name;
	private String s_name;
	private String u_name;
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getM_sendid() {
		return m_sendid;
	}
	public void setM_sendid(int m_sendid) {
		this.m_sendid = m_sendid;
	}
	public int getM_receiveid() {
		return m_receiveid;
	}
	public void setM_receiveid(int m_receiveid) {
		this.m_receiveid = m_receiveid;
	}
	public String getM_theme() {
		return m_theme;
	}
	public void setM_theme(String m_theme) {
		this.m_theme = m_theme;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public Timestamp getM_sendtime() {
		return m_sendtime;
	}
	public void setM_sendtime(Timestamp m_sendtime) {
		this.m_sendtime = m_sendtime;
	}
	public int getM_sendstatus() {
		return m_sendstatus;
	}
	public void setM_sendstatus(int m_sendstatus) {
		this.m_sendstatus = m_sendstatus;
	}
	public int getM_receivestatus() {
		return m_receivestatus;
	}
	public void setM_receivestatus(int m_receivestatus) {
		this.m_receivestatus = m_receivestatus;
	}
	
	
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	@Override
	public String toString() {
		return "Mail [m_id=" + m_id + ", m_sendid=" + m_sendid + ", m_receiveid=" + m_receiveid + ", m_theme=" + m_theme
				+ ", m_content=" + m_content + ", m_sendtime=" + m_sendtime + ", m_sendstatus=" + m_sendstatus
				+ ", m_receivestatus=" + m_receivestatus + ", r_name=" + r_name + ", s_name=" + s_name + ", u_name="
				+ u_name + "]";
	}
	
}
