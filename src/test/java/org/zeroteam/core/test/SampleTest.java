package org.zeroteam.core.test;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zeroteam.core.sample.SampleBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class SampleTest {

	@Inject
	private SampleBean bean;
	
	@Test
	public void testExist(){
		
		Assert.assertNotNull(bean);
	}
}
