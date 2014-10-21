package com.Global;

import j2se.modules.Helper.DLog;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.PooledDataSource;
import com.xinyuan.message.ConfigConstants;

public class ServletEventListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DLog.log("--------- contextInitialized ---------");
		
		ConfigConstants.initializeContextVariables(sce.getServletContext());
		ConfigConstants.initializeSystemProperties();
		
		DLog.log("--------------- Hibernate initialize Begin ----------------\n");
		HibernateInitializer.initialize();
		DLog.log("--------------- Hibernate initialize End 	 ----------------\n");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DLog.log("--------- contextDestroyed ---------");
		
		@SuppressWarnings("unchecked")
		Set<PooledDataSource> pooledDataSourceSet = (Set<PooledDataSource>) C3P0Registry.getPooledDataSources();

	    for (PooledDataSource dataSource : pooledDataSourceSet) {
	        try {
	            dataSource.hardReset();
	            dataSource.close();
	        } catch (SQLException e) {
	            // note - do not use log4j since it may have been unloaded by this point
	            System.out.println("Unable to hard reset and close data source. \n" + e);
	        }
	    }
	}

}
