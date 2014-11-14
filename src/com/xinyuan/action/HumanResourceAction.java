package com.xinyuan.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.Global.HibernateInitializer;
import com.hanvon.faceid.sdk.FaceId;
import com.hanvon.faceid.sdk.FaceIdAnswer;
import com.hanvon.faceid.sdk.FaceId_ErrorCode;
import com.opensymphony.xwork2.Action;
import com.xinyuan.Util.GsonHelper;
import com.xinyuan.Util.ParametersHelper;
import com.xinyuan.dao.SuperDAO;
import com.xinyuan.dao.impl.HumanResourceDAOIMP;
import com.xinyuan.dao.impl.SuperDAOIMP;
import com.xinyuan.message.ConfigConstants;
import com.xinyuan.model.Approval.Approvals;
import com.xinyuan.model.HumanResource.EmployeeAttendanceRecord;
import com.xinyuan.model.Setting.APPSettings;

public class HumanResourceAction extends SuperAction {
	private static final long serialVersionUID = 1L;
	
	
	private List<EmployeeAttendanceRecord> emplist;
	
	

	public List<EmployeeAttendanceRecord> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<EmployeeAttendanceRecord> emplist) {
		this.emplist = emplist;
	}


	@Override
	protected SuperDAO getDao() {
		return new HumanResourceDAOIMP();
	}

	public String trace() {
		
		final String traceUser = ParametersHelper.getParameter(requestMessage, "User");
		
		final Map<String, List<Object>> orderResults = new HashMap<String, List<Object>>();
		
		HibernateInitializer.getSessionFactory().getCurrentSession().doWork(new Work() {
					@Override
					public void execute(Connection connection) throws SQLException {
						// TODO Auto-generated method stub
						String connectionURL = connection.getMetaData().getURL();
						String dbName = connectionURL.substring(connectionURL.lastIndexOf("/") + 1);
						
						String callProcedureString = "{call getAllTraceTables('" + dbName + "')}";
						ResultSet tableResult = connection.prepareStatement(callProcedureString).executeQuery();
						
						while (tableResult.next()) {
							String tableName = tableResult.getString("ATableName");
											
							int dayCount = 2 ; //default
							HumanResourceDAOIMP daoimp = (HumanResourceDAOIMP)getDao();
							APPSettings appSettings = (APPSettings)daoimp.getObject(APPSettings.class, "type", "ADMIN_APNS_TraceFilesDate");
							String jsonString = appSettings.getSettings();
							Map<String, Object> map = GsonHelper.translateJsonStringToMap(jsonString);
							if (map != null) {
							    Map<String, String> paraMap = (Map<String, String>)map.get("PARAMETERS");
                                if (paraMap != null) {
                                    String dayCountString = paraMap.get("KEYS.save.Day.count");
                                    if (dayCountString != null) {
                                        dayCount = Integer.valueOf(dayCountString);
                                    }
                                }
                            }
							
							
							Calendar cal = Calendar.getInstance();
							cal.add(Calendar.DAY_OF_MONTH, -dayCount);
							Date date = cal.getTime();
							
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String dateString = format.format(date);
							String callProcedureStr = "{call getTraceResults('" + dbName + "', '" + tableName + "', '" + dateString + "', '" + traceUser + "', " + 0 + " )}";
							ResultSet values = connection.prepareStatement(callProcedureStr).executeQuery();
							
							List<Object> outterResults = new ArrayList<Object>();
							while (values.next()) {
								String orderNO = values.getString("orderNO");
								
								outterResults.add(orderNO);
							}
							orderResults.put(tableName, outterResults);
							
						}
					}
				});
		
		Approvals pendingApproval = (Approvals)(new SuperDAOIMP()).getObject(Approvals.class, traceUser);
		String unReadApprovals = pendingApproval.getUnReadApprovals();

		List<Object> results = new ArrayList<Object>();
		results.add(orderResults);
		results.add(unReadApprovals);
		
		responseMessage.results = results;
		responseMessage.status = ConfigConstants.STATUS_POSITIVE;
		return Action.NONE;
	}
	
	public String attendance() throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fromDate = simpleDateFormat.parse("2014-11-12 14:50:00");
		Date toDate = new Date();
		
		List<String> recordList = this.getRecordList(fromDate, toDate, "192.168.0.2", "9922");
		this.saveRecordListToDataBase(recordList);
		
		
//		EmployeeAttendanceRecord att = new EmployeeAttendanceRecord();
//		AttendanceRecordDAOIMP atm = new AttendanceRecordDAOIMP();
//		atm.setSessionFactory(HibernateInitializer.getSessionFactory());
//		if(requestMessage != null) {
//		   emplist = atm.FindAttendanceRecord();
//		   responseMessage.results=emplist;
//		}
		return Action.NONE;
		
	}
	
	
	/**
	 * 
	 * @param fromTime 
	 * @param ip			192.168.0.2
	 * @param port			9922
	 * @throws Exception
	 */
	public List<String> getRecordList(Date fromDate, Date toDate, String ip, String port) throws Exception {
		List<String> recordList = new LinkedList<>();

		String timeFormat = "yyyy-MM-dd HH:mm:ss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat);

		try (FaceId tcpClient = new FaceId(ip, Integer.parseInt(port))) {

			String fromTimeString = simpleDateFormat.format(fromDate);
			String toTimeString = simpleDateFormat.format(toDate);

			String Command = "GetRecord(start_time=\"" + fromTimeString + "\"" +" end_time=\"" + toTimeString + "\")";

			FaceIdAnswer output = new FaceIdAnswer();
			FaceId_ErrorCode ErrorCode = tcpClient.Execute(Command, output, "GBK");

			if (ErrorCode.equals(FaceId_ErrorCode.Success)) {

				Pattern p = Pattern.compile("\\b(time=.+)\\R");

				Matcher m = p.matcher(output.answer);

				while (m.find()) {
					String one = m.group(1);
					recordList.add(one);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return recordList;
	}
	
	
	public void saveRecordListToDataBase(List<String> recordList) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Pattern timePattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}");
		Pattern namePattern = Pattern.compile("name=\"(\\S*)\"");
		Pattern idPattern = Pattern.compile("id=\"(\\d+)\"");
		
		Transaction transaction = HibernateInitializer.getSessionFactory().getCurrentSession().beginTransaction();
		
		for (int i = 0; i < recordList.size(); i++) {
			String recordString = recordList.get(i);
			String identification = null;
			String name = null;
			Date time = null;
			
			Matcher idMatcher = idPattern.matcher(recordString);
			if (idMatcher.find()) {
				identification = idMatcher.group(1);
			}
			
			Matcher timeMatcher = timePattern.matcher(recordString);
			if (timeMatcher.find()){
				String timeString = timeMatcher.group();
				time = simpleDateFormat.parse(timeString);
			}
			
			
			Matcher nameMatcher = namePattern.matcher(recordString);
			if (nameMatcher.find()) {
				name = nameMatcher.group(1);
			}
			
			EmployeeAttendanceRecord record = new EmployeeAttendanceRecord();
			record.setIdentification(identification);
			record.setTime(time);
			record.setName(name);
			
			dao.create(record);
		}
		
		transaction.commit();
	}
	
}

