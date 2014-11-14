package com.xinyuan.action;

import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.ApprovalDAOIMP;

public class ApprovalAction extends SuperAction {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected SuperDAO getDao() {
		return new ApprovalDAOIMP();
	}
	
	
}
