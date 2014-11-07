package com.xinyuan.model.Attendance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
@Table
@Entity
public class AttendanceRecord {
	private static final long serialVersionUID = 1L;
	private Date time;//考勤记录时间
	private int id;//考勤记录id
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getCard_src() {
		return card_src;
	}
	public void setCard_src(String card_src) {
		this.card_src = card_src;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String name;//姓名
	private  String authority;//权限
	private String card_src;//头像
	
	

}
