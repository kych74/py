package org.zeroteam.core.test;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zeroteam.core.sample.mapper.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class SampleMapperTest {

	static Logger logger = Logger.getLogger(SampleMapperTest.class);
	
	@Inject
	SampleMapper mapper;
	
	@Test
	public void testGetTime(){
		
		logger.info("----------------");
		logger.info(mapper);
		logger.info(mapper.getTime());
		logger.info("================");
		
	}
	
}
