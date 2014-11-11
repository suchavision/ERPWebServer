package com.xinyuan.model.Finance;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.BaseBill;

@Table
@Entity
public class FinaceReceiptBill extends BaseBill {

	private static final long serialVersionUID = 1L;
	
	
	private String receiptOrderNO ;			// 收款单号
	
	
	private String referenceOrderType;		// 引用单类型: 进货单/派车单
	private String referenceOrderNO;		// 单号
	private String productName;				// 品名
	
	private float shouldPay;				// 应付金额 
	private float realPaid;					// 实付金额
	
	
	public String getReceiptOrderNO() {
		return receiptOrderNO;
	}
	public void setReceiptOrderNO(String receiptOrderNO) {
		this.receiptOrderNO = receiptOrderNO;
	}
	public String getReferenceOrderType() {
		return referenceOrderType;
	}
	public void setReferenceOrderType(String referenceOrderType) {
		this.referenceOrderType = referenceOrderType;
	}
	public String getReferenceOrderNO() {
		return referenceOrderNO;
	}
	public void setReferenceOrderNO(String referenceOrderNO) {
		this.referenceOrderNO = referenceOrderNO;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getShouldPay() {
		return shouldPay;
	}
	public void setShouldPay(float shouldPay) {
		this.shouldPay = shouldPay;
	}
	public float getRealPaid() {
		return realPaid;
	}
	public void setRealPaid(float realPaid) {
		this.realPaid = realPaid;
	}
}
