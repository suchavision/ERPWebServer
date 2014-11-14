package com.xinyuan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xinyuan.model.HumanResource.EmployeeAttendanceRecord;

public class AttendanceRecordDAOIMP extends ModelDAOIMP {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<EmployeeAttendanceRecord> FindAttendanceRecord()
	{
		List<AttendanceRecordDAOIMP> list=new ArrayList<AttendanceRecordDAOIMP>();
		String hql="select * from EmployeeAttendanceRecord";
		Session session=this.getSessionFactory().getCurrentSession();
	    Query query=session.createQuery(hql);
		return query.list();
	}

}
