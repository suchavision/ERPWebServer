package com.xinyuan.action.command.Finance;

import java.util.List;

import com.xinyuan.action.command.category.FinanceCommandApply;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.FinanceDAOIMP;
import com.xinyuan.model.Finance.FinancePaymentBill;
import com.xinyuan.model.Finance.FinancePaymentOrder;
import com.xinyuan.model.Warehouse.WHPurchaseOrder;

public class FinancePaymentOrderCommandApply extends FinanceCommandApply {

	@Override
	protected void handleFinalApprovalProcess(SuperDAO dao, Object persistence) throws Exception {
		super.handleFinalApprovalProcess(dao, persistence);
		
		FinancePaymentOrder financePaymentOrder = (FinancePaymentOrder)persistence;
		String paymentOrderNO = financePaymentOrder.getOrderNO();
		
		FinanceDAOIMP financeDAOIMP = (FinanceDAOIMP)dao;
		List<FinancePaymentBill> bills = (List<FinancePaymentBill>)financeDAOIMP.getObjects(FinancePaymentBill.class, "paymentOrderNO", paymentOrderNO);
		
		for (int i = 0; i < bills.size(); i++) {
			FinancePaymentBill bill = bills.get(i);
			float unpaid = bill.getShouldPay() - bill.getRealPaid();
			
			String referenceOrderType = bill.getReferenceOrderType();  // WHPurchaseOrder ....
			
			if (referenceOrderType.equals("WHPurchaseOrder")) {
				String referenceOrderNO = bill.getReferenceOrderNO();
				WHPurchaseOrder obj = (WHPurchaseOrder)financeDAOIMP.getObject(WHPurchaseOrder.class, "orderNO", referenceOrderNO);
				obj.setShouldPay(unpaid);
				
				financeDAOIMP.modify(obj);
			}
		}	
	}

	
}
