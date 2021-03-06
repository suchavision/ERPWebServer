package com.xinyuan.model.HumanResource;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.xinyuan.model.OrderApp1;


/**
 * 保安人员用餐明细表
 *
 * SM : Security Meal
 */

@Entity
@Table
public class EmployeeSMOrder extends OrderApp1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeNO ; // 员工编号

	private Date mealDate;		// 日期
	
	
	private boolean morningMeal;	// 早
	private boolean noonMeal;		// 午
	private boolean eveningMeal;	// 晚
	
	private Set<EmployeeSMBill> bills;
	
	public Date getMealDate() {
		return mealDate;
	}
	public void setMealDate(Date mealDate) {
		this.mealDate = mealDate;
	}
	public String getEmployeeNO() {
		return employeeNO;
	}
	public void setEmployeeNO(String employeeNO) {
		this.employeeNO = employeeNO;
	}
	public boolean isMorningMeal() {
		return morningMeal;
	}
	public void setMorningMeal(boolean morningMeal) {
		this.morningMeal = morningMeal;
	}
	public boolean isNoonMeal() {
		return noonMeal;
	}
	public void setNoonMeal(boolean noonMeal) {
		this.noonMeal = noonMeal;
	}
	public boolean isEveningMeal() {
		return eveningMeal;
	}
	public void setEveningMeal(boolean eveningMeal) {
		this.eveningMeal = eveningMeal;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="order")
	public Set<EmployeeSMBill> getBills() {
		return bills;
	}
	public void setBills(Set<EmployeeSMBill> bills) {
		this.bills = bills;
	}
	
}