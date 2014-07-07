package org.zeroteam.core.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class DataSourceTest {

	private static Logger logger = Logger.getLogger(DataSourceTest.class);
	
	@Inject
	DataSource ds;
	
	
	@Test
	public void testExist(){
		
		Assert.assertNotNull(ds);
		
	}
	
	
	@Test
	public void testConnection()throws Exception{
		
		logger.info("connection test");
		Connection con = ds.getConnection();
		logger.info(con);
		
	}
	
}

