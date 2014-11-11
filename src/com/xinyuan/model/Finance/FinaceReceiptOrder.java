package com.xinyuan.model.Finance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.OrderApp4;


@Table
@Entity
public class FinaceReceiptOrder extends OrderApp4 {

	private static final long serialVersionUID = 1L;
	
	
	private String receiver;		// 收款人
	private String payer;			// 付款人
	
	
	private String accountNumber;   // 帐户编号 
	private String accountName;		// 帐户名

	private String receiveMode;		// 收款方式
	private Date receiveDate;		// 收款日期
	
	private String feeDescription;  // 费用说明
	
	

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getReceiveMode() {
		return receiveMode;
	}

	public void setReceiveMode(String receiveMode) {
		this.receiveMode = receiveMode;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getFeeDescription() {
		return feeDescription;
	}

	public void setFeeDescription(String feeDescription) {
		this.feeDescription = feeDescription;
	}
	
}
