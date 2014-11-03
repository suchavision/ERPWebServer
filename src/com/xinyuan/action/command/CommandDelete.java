package com.xinyuan.action.command;

import j2se.modules.Introspector.IntrospectHelper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.xinyuan.Util.ApprovalsDAOHelper;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.message.MessagesException;
import com.xinyuan.message.MessagesKeys;
import com.xinyuan.model.BaseOrder;
import com.xinyuan.model.IApp;

public class CommandDelete extends CommandAlter {

	@Override
	protected void handlePersistence(SuperDAO dao, Object model, Set<String> modelkeys, Object persistence) throws Exception {
		dao.delete(persistence);
		MessagesKeys.getCurrentResponseMessage().descriptions = MessagesKeys.DEFAULT;
		
		// check if delete successfully
		Set<String> keys = new HashSet<String>();
		Set<String> properties = IntrospectHelper.getAllProperties(persistence);
		for (Iterator<String> iterator = properties.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (!string.contains("Bill")) {
				keys.add(string);
			}
		}
		if (dao.readUnique(persistence, keys) != null) {
		    throw new MessagesException(MessagesKeys.DEFAULT);
		}
	}

	@Override
	protected void handleApprovals(SuperDAO dao, String appKey, String forwardUser, BaseOrder persistence) throws Exception {
		if (persistence instanceof IApp) ApprovalsDAOHelper.deletePendingApprove(((IApp)persistence).getForwardUser(), persistence);
	}

	
}
