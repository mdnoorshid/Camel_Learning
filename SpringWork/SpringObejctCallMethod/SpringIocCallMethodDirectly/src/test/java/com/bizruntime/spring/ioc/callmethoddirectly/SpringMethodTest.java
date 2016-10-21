package com.bizruntime.spring.ioc.callmethoddirectly;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class represents the test cases for spring prototype scope
 * @author bizruntime
 *
 */
public class SpringMethodTest {

	static Logger log=Logger.getLogger(SpringMethodTest.class);
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
	 * @throws BeanException 
	 */
	@Test
	public void beanTest() throws BeanException{
		try{
      String name=(String) applicationContext.getBean("static");
        Assert.assertEquals(name, "Md");
		log.debug(name);
		}catch(BeanCreationException e){
			throw new BeanException("Failed to create the bean",e);
		}
		/*String name1=(String) applicationContext.getBean("nonstatic");
		log.debug(name1);
		CallNonStatic callNonStatic= (CallNonStatic) applicationContext.getBean("getNonStaticName");
		log.debug(callNonStatic.getName("noorshid"));*/
	}
	
	
}
