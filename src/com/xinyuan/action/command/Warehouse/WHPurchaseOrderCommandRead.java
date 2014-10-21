package com.xinyuan.action.command.Warehouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;

import com.Global.HibernateInitializer;
import com.xinyuan.Util.AppModelsHelper;
import com.xinyuan.action.command.category.WarehouseCommandRead;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.SuperDAOIMP;
import com.xinyuan.message.RequestMessage;
import com.xinyuan.message.ResponseMessage;
import com.xinyuan.model.Finance.FinancePaymentBill;
import com.xinyuan.model.Finance.FinancePaymentOrder;
import com.xinyuan.model.Warehouse.WHPurchaseOrder;

public class WHPurchaseOrderCommandRead extends WarehouseCommandRead {

	@Override
	public void execute(SuperDAO dao, ResponseMessage responseMessage, RequestMessage requestMessage, List<Object> models, List<Set<String>> modelsKeys) throws Exception {
		super.execute(dao, responseMessage, requestMessage, models, modelsKeys);
		
		if (requestMessage.getFIELDS() != null) {
			return;
		}
		SuperDAOIMP daoimp = (SuperDAOIMP)dao;
		WHPurchaseOrder vo = (WHPurchaseOrder)models.get(0);
		 Map<String, Object> keyValues = new HashMap<String, Object>();
		 keyValues.put("id", vo.getId());
		WHPurchaseOrder po = AppModelsHelper.getPersistenceByUniqueKeyValue(dao, keyValues, vo.getClass());
		String orderNO = po.getOrderNO();
		
		
		String queryString = "FROM FinancePaymentBill WHERE referenceOrderType=:referenceOrderType AND referenceOrderNO=:referenceOrderNO " ; 
		Query query = HibernateInitializer.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setParameter("referenceOrderType", "WHPurchaseOrder");
		query.setParameter("referenceOrderNO", orderNO);
		
		
		List list=new ArrayList<Object>();
		
		List<FinancePaymentBill> financePaymentBills = query.list();
		for (int i = 0; i < financePaymentBills.size(); i++) {
			FinancePaymentBill bill = financePaymentBills.get(i);
			String paymentOrderNO = bill.getPaymentOrderNO();
			List<Object> ain=new ArrayList<Object>();
			FinancePaymentOrder financePaymentOrder = (FinancePaymentOrder)daoimp.getObject(FinancePaymentOrder.class, "orderNO", paymentOrderNO);
			
			Date payDate = financePaymentOrder.getCreateDate();
			float shouldPay = bill.getShouldPay();
			float unPay = bill.getRealPaid();
			
			ain.add(payDate);
			ain.add(paymentOrderNO);
			ain.add(shouldPay);
			ain.add(unPay);
			list.add(ain);
		}

		((List<Object>)responseMessage.results).add(list);
		
		
	}
	
	

}
