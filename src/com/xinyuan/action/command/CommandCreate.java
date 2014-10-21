package com.xinyuan.action.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xinyuan.Query.QueryCriteriasHelper;
import com.xinyuan.Util.ApprovalsDAOHelper;
import com.xinyuan.Util.OrderNOGenerator;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.message.ConfigConstants;
import com.xinyuan.message.ConfigJSON;
import com.xinyuan.message.RequestMessage;
import com.xinyuan.message.ResponseMessage;
import com.xinyuan.model.BaseModel;
import com.xinyuan.model.BaseOrder;
import com.xinyuan.model.IApp;

public class CommandCreate implements Command {

	@Override
	public void execute(SuperDAO dao, ResponseMessage responseMessage, RequestMessage requestMessage, List<Object> models, List<Set<String>> modelsKeys) throws Exception {
}
}