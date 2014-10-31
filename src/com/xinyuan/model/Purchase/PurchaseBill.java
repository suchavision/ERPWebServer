package com.xinyuan.model.Purchase;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.BaseBill;

@Table
@Entity
public class PurchaseBill extends BaseBill {
	
	private static final long serialVersionUID = 1L;

	private String purchaseOrderNO;
	
	private String productCode;		//产品代码
	private String productName;		//品名规格
	private float amount;			//数量
	private String unit;			//单位
	private float unitPrice;		//单价
	
	
	public String getPurchaseOrderNO() {
		return purchaseOrderNO;
	}
	public void setPurchaseOrderNO(String purchaseOrderNO) {
		this.purchaseOrderNO = purchaseOrderNO;
	}
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
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

}
