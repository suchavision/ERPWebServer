package com.xinyuan.model.Warehouse;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.BillApp2;

@Entity
@Table
public class WHLendOutBill extends BillApp2 {
	
	private static final long serialVersionUID = 1L;
	
	private String referenceOrderNO; // JCD 单号
	
	private float returnAmount; //还入数量
	private Date returnDate; //还入日期
	
	private String createUser; //制单人
	
	
	
	
	public String getReferenceOrderNO() {
		return referenceOrderNO;
	}
	public void setReferenceOrderNO(String referenceOrderNO) {
		this.referenceOrderNO = referenceOrderNO;
	}
	public float getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(float returnAmount) {
		this.returnAmount = returnAmount;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
	
	
}
