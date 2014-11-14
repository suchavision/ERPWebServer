package com.xinyuan.model.Approval;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.BaseModel;


/**
 * Returned Order Reasons and Logs 
 *
 */

@Entity
@Table
public class ApprovalsReturnedRecord extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private String orderType;			// 退审单类型
	private String orderNO;				// 退审单号

	private String reason;				// 退审原因


	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	
	

	@Column(columnDefinition="TEXT")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
}
