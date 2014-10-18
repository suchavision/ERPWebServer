package com.xinyuan.action;

import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.WarehouseDAOIMP;

public class WarehouseAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	@Override
	protected SuperDAO getDao() {
		return new WarehouseDAOIMP();
	}
	
//	@Override
//	public String apply() throws Exception {
//		// TODO Auto-generated method stub
//		super.apply();
//		
//
//		Object model = models.get(0);
//		
//		List<Map<String, String>> identityList = requestMessage.getIDENTITYS();
//		WarehouseConstraint.applyModify(model, identityList.get(0));
//		
//		String billKey = ParametersHelper.getParameter(requestMessage, ConfigJSON.ISBILL);
//		if (billKey == null || !Boolean.valueOf(billKey)) return Action.NONE;
//		
//		
//		
//		Object persistence = AppModelsHelper.getPersistenceByUniqueKeyValue(dao,requestMessage.getIDENTITYS().get(0), model.getClass());
//		
//		if (persistence instanceof WHLendOutBill) {
//			WHLendOutBill bill = (WHLendOutBill)persistence;
//			String department = IntrospectHelper.getParentPackageName(bill);
//			String orderType = "WHLendOutOrder";
//			String orderNO = bill.getBillNO();
//			ApprovalsDAOHelper.addPendingApprove(bill.getForwardUser(),department , orderType, orderNO);
//		}
//		return Action.NONE;
//	}
	
}
