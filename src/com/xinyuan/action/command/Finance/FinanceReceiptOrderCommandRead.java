package com.xinyuan.action.command.Finance;

import java.util.List;
import java.util.Set;

import com.xinyuan.action.command.category.FinanceCommandRead;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.message.RequestMessage;
import com.xinyuan.message.ResponseMessage;

public class FinanceReceiptOrderCommandRead extends FinanceCommandRead {
	
	
	@Override
	public void execute(SuperDAO dao, ResponseMessage responseMessage, RequestMessage requestMessage, List<Object> models, List<Set<String>> modelsKeys) throws Exception {
		super.execute(dao, responseMessage, requestMessage, models, modelsKeys);
		
		
	}

}
