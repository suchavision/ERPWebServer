package com.modules.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xinyuan.action.HumanResourceAction;

public class Test {

	public static void main(String[] args) {
		
		HumanResourceAction action = new HumanResourceAction();
		
		try {
		
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fromDate = simpleDateFormat.parse("2014-11-12 14:50:00");
			Date toDate = new Date();
			
			List<String> recordList = action.getRecordList(fromDate, toDate, "192.168.0.2", "9922");
			action.saveRecordListToDataBase(recordList);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
