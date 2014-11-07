package com.xinyuan.model.Purchase;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.BaseBill;
@Table
@Entity
public class PurchaseRequisitionBill extends BaseBill {
	
	private static final long serialVersionUID = 1L;
	
	private String productCode;		//产品编号
	private String productName;		//品名规格
	private float amount;			//数量
	private String unit;			//单位
	private float unitPrice1;		//单价1
	private float unitPrice2;    //单价2
	private float unitPrice3;    //单价3
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getUnitPrice1() {
		return unitPrice1;
	}
	public void setUnitPrice1(float unitPrice1) {
		this.unitPrice1 = unitPrice1;
	}
	public float getUnitPrice2() {
		return unitPrice2;
	}
	public void setUnitPrice2(float unitPrice2) {
		this.unitPrice2 = unitPrice2;
	}
	public float getUnitPrice3() {
		return unitPrice3;
	}
	public void setUnitPrice3(float unitPrice3) {
		this.unitPrice3 = unitPrice3;
	}


}
