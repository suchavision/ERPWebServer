package com.xinyuan.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jdbc.Work;

import com.Global.HibernateInitializer;
import com.opensymphony.xwork2.Action;
import com.xinyuan.Util.GsonHelper;
import com.xinyuan.Util.ParametersHelper;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.HumanResourceDAOIMP;
import com.xinyuan.dao.impl.SuperDAOIMP;
import com.xinyuan.message.ConfigConstants;
import com.xinyuan.model.Approval.Approvals;
import com.xinyuan.model.Setting.APPSettings;

public class HumanResourceAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	@Override
	protected SuperDAO getDao() {
		return new HumanResourceDAOIMP();
	}

	public String trace() {
		final String trancUser=ParametersHelper.getParameter(requestMessage, "User");
		return Action.NONE;
	
	
	}
}
