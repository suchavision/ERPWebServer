package com.xinyuan.action.command.Finance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Model;

import com.xinyuan.action.command.category.WarehouseCommandRead;
import com.xinyuan.dao.PurchaseDAO;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.PurchaseDAOIMP;
import com.xinyuan.dao.impl.PurchaseOrderDaoImpl;
import com.xinyuan.message.RequestMessage;
import com.xinyuan.message.ResponseMessage;
import com.xinyuan.model.Purchase.PurchaseBill;

public class PurchaseOrderCommandRead extends FinanceReceiptOrderCommandRead {
	@Override
	public void execute(SuperDAO dao, ResponseMessage responseMessage, RequestMessage requestMessage, List<Object> models, List<Set<String>> modelsKeys) throws Exception {
		super.execute(dao, responseMessage, requestMessage, models, modelsKeys);
		
        
		
		
	}

}
