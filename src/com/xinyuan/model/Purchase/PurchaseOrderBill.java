package com.xinyuan.model.Purchase;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.BaseBill;

@Table
@Entity
public class PurchaseOrderBill extends BaseBill {
	
	private static final long serialVersionUID = 1L;

	private String purchaseOrderNO;
	
	private String productNo;//产品代码
	private String standard;//品名规格
	private float number;//数量
	private String institution;//单位
	private float price;//单价
	
	
	public String getPurchaseOrderNO() {
		return purchaseOrderNO;
	}
	public void setPurchaseOrderNO(String purchaseOrderNO) {
		this.purchaseOrderNO = purchaseOrderNO;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getStatistics() {
		return statistics;
	}
	public void setStatistics(float statistics) {
		this.statistics = statistics;
	}
	private float statistics;//小计
	
	
	

}
