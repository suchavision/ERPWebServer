package com.xinyuan.action.command.Purchase;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.xinyuan.Util.ParametersHelper;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.SuperDAOIMP;
import com.xinyuan.message.RequestMessage;
import com.xinyuan.message.ResponseMessage;
import com.xinyuan.model.Purchase.PurchaseRequisitionBill;

public class PurchaseRequisitionOrderCommandApply extends PurchaseCommandApply {

	@Override
	public void execute(SuperDAO dao, ResponseMessage responseMessage, RequestMessage requestMessage, List<Object> models, List<Set<String>> modelsKeys) throws Exception {
		super.execute(dao, responseMessage, requestMessage, models, modelsKeys);
		
		
		Serializable id = ParametersHelper.getParameter(requestMessage, "shouldDeleteBillId");
		if (id == null) return;
		if (id instanceof String) {
			id = Integer.parseInt(((String)id));
		}
		SuperDAOIMP superDAOIMP = (SuperDAOIMP)dao;
		Object persitence = superDAOIMP.getObject(PurchaseRequisitionBill.class, id);
		superDAOIMP.delete(persitence);
	}

	
}
