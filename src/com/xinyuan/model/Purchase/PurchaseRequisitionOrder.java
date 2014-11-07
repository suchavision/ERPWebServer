package com.xinyuan.model.Purchase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xinyuan.model.OrderApp4;
@Table
@Entity
public class PurchaseRequisitionOrder extends OrderApp4 {
	
	private static final long serialVersionUID = 1L;
	
	private Date requisitionDate;				// 日期
	
	private String vendorName; 			//承办厂商名字
	private String vendorNumber;		// 承办厂商编号
	
	private String vendorName1; 			//承办厂商名字
	private String vendorNumber1;		// 承办厂商编号
	
	private String vendorName2; 			//承办厂商名字
	private String vendorNumber2;		// 承办厂商编号
	
	private String vendorName3; 			//承办厂商名字
	private String vendorNumber3;		// 承办厂商编号

	
	private String purpose;				// 用途
	

	public Date getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public String getVendorName1() {
		return vendorName1;
	}

	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}

	public String getVendorNumber1() {
		return vendorNumber1;
	}

	public void setVendorNumber1(String vendorNumber1) {
		this.vendorNumber1 = vendorNumber1;
	}

	public String getVendorName2() {
		return vendorName2;
	}

	public void setVendorName2(String vendorName2) {
		this.vendorName2 = vendorName2;
	}

	public String getVendorNumber2() {
		return vendorNumber2;
	}

	public void setVendorNumber2(String vendorNumber2) {
		this.vendorNumber2 = vendorNumber2;
	}

	public String getVendorName3() {
		return vendorName3;
	}

	public void setVendorName3(String vendorName3) {
		this.vendorName3 = vendorName3;
	}

	public String getVendorNumber3() {
		return vendorNumber3;
	}

	public void setVendorNumber3(String vendorNumber3) {
		this.vendorNumber3 = vendorNumber3;
	}
	
	@Column(columnDefinition="TEXT")
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
