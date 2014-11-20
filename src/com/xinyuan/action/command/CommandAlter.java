package com.xinyuan.action.command;

import j2se.modules.Introspector.IntrospectHelper;
import j2se.modules.Introspector.ObjectIntrospector;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.Global.SessionManager;
import com.xinyuan.Util.ApnsHelper;
import com.xinyuan.Util.AppModelsHelper;
import com.xinyuan.Util.ApprovalsDAOHelper;
import com.xinyuan.Util.ParametersHelper;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.SuperDAOIMP;
import com.xinyuan.message.ConfigConstants;
import com.xinyuan.message.ConfigJSON;
import com.xinyuan.message.RequestMessage;
import com.xinyuan.message.ResponseMessage;
import com.xinyuan.model.BaseBill;
import com.xinyuan.model.BaseOrder;
import com.xinyuan.model.IApp;
import com.xinyuan.model.User.User;

public abstract class CommandAlter implements Command {

	@Override
	public void execute(SuperDAO dao, ResponseMessage responseMessage, RequestMessage requestMessage, List<Object> models, List<Set<String>> modelsKeys) throws Exception {
		
		List<String> forwardsList = requestMessage.getAPNS_FORWARDS();
		List<Map<String, Object>> identityList = requestMessage.getIDENTITYS();	
		List<Map<String, Object>> forwardsContents = requestMessage.getAPNS_CONTENTS();
		
		for (int i = 0; i < models.size(); i++) {
			Object model = models.get(i);
			Set<String> modelkeys = modelsKeys.get(i);
			
			// get the persistence by identities
			Object persistence = AppModelsHelper.getPersistenceByUniqueKeyValue(dao, identityList.get(i), model.getClass());
			// subclass, handle the persistence
			handlePersistence(dao, model, modelkeys, persistence);
			
			String forwardUser = forwardsList != null && forwardsList.size() > i ? forwardUser = forwardsList.get(i) : null;
			if (forwardUser == null) {
				if (persistence instanceof IApp) {
					forwardUser = ((IApp) persistence).getForwardUser();
				}
			}
			String appKey = ParametersHelper.getParameter(requestMessage, ConfigJSON.APPLEVEL);
			
			// apns & pendings
			if (persistence instanceof BaseOrder) {
				// subclass, handle the pending approvals
				BaseOrder baseOrder = (BaseOrder)persistence;
				handleApprovals(dao, appKey, forwardUser, baseOrder);
				
			} else if (persistence instanceof BaseBill) {
				BaseBill baseBill = (BaseBill)persistence;
				String billClassName = IntrospectHelper.getLongClassName(baseBill);
				String orderClassName = billClassName.replace("Bill", "Order");
				String referenceOrderNO = (String)ObjectIntrospector.getProperty(baseBill, "referenceOrderNO");
				if (referenceOrderNO != null) {
					
					SuperDAOIMP superDAOIMP = (SuperDAOIMP)dao;
					BaseOrder baseOrder = superDAOIMP.readUnique(Class.forName(orderClassName), "orderNO", referenceOrderNO);
					
					// Handle The Pending Approvals
					ApprovalsDAOHelper.handlePendingApprovals(dao, null, forwardUser, baseOrder);
					
					if (baseBill instanceof IApp) {
			            ((IApp) baseBill).setForwardUser(forwardUser);
			            if (appKey != null) {
			            	String signinedUser = ((User)SessionManager.get(ConfigConstants.SIGNIN_USER)).getUsername();
			            	ObjectIntrospector.setProperty(baseBill, appKey, signinedUser);
			            }
			            dao.modify(baseBill);
					}
				
				}
			}
		}
		
		ApnsHelper.infromApns(forwardsList, forwardsContents);
		
		responseMessage.status = ConfigConstants.STATUS_POSITIVE;
	}
	
	
	protected abstract void handlePersistence(SuperDAO dao, Object model, Set<String> modelkeys, Object persistence) throws Exception ;
	protected abstract void handleApprovals(SuperDAO dao, String appKey, String forwardUser, BaseOrder persistence) throws Exception ;
	
}


