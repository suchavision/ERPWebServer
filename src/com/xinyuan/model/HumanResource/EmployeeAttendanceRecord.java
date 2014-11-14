package com.xinyuan.model.HumanResource;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
@Entity
public class EmployeeAttendanceRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;			//考勤记录id
	private Date time;		//考勤记录时间
	private String name;	//姓名
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Id
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

}
