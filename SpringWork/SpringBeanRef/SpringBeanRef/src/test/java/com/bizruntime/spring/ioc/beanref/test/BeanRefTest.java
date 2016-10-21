package com.bizruntime.spring.ioc.beanref.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bizruntime.spring.ioc.beanref.CalledPrinterJavaBean;

/**
 * This class represents the test cases for spring prototype scope
 * @author bizruntime
 *
 */
public class BeanRefTest {

	static Logger log=Logger.getLogger(BeanRefTest.class);
	  ApplicationContext applicationContext;
	/**
	 * This method is responsible for loading the application context file and
	 * initialize the application context object.
	 * @throws FileNotFoundExcep
	 */
	@Before
	public void loadContext() throws FileNotFoundExcep{
		try{
	  applicationContext=new ClassPathXmlApplicationContext("Spring-Module.xml");
	  Assert.assertNotNull("applicationContext object should not be null", applicationContext);
	  }catch(Exception e){
		  throw new FileNotFoundExcep("File not loaded from the classpath!!",e);
	  }
	}
	/**
	 * This method is responsible for the testing the prototype objects with their 
	 * unique hash code value
	 */
	@Test
	public void beanTest(){
	CalledPrinterJavaBean calledPrinterJavaBean=(CalledPrinterJavaBean) applicationContext.getBean("CalledPrinter");
	String name=calledPrinterJavaBean.getCalled("noorshid");
	log.debug(name);
	}
	
	
}
