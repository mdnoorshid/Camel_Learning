package com.bizruntime.spring.ioc.scope.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bizruntime.spring.ioc.persistence.MessageSpringScope;

/**
 * This class represents the test cases for spring prototype scope
 * @author bizruntime
 *
 */
public class SpringPrototypeScopeTest {

	static Logger log=Logger.getLogger(SpringPrototypeScopeTest.class);
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
     MessageSpringScope messageSpringScope=(MessageSpringScope) applicationContext.getBean("messageSpringScope");
     Assert.assertNotNull("Object should not be null", messageSpringScope);
	  messageSpringScope.setMessage("Hello how are you!!");
	  String message=messageSpringScope.getMessage();
	  Assert.assertEquals(message,"Hello how are you!!");
	  log.debug("Message is--->"+message);
     MessageSpringScope messageSpringScope1=(MessageSpringScope) applicationContext.getBean("messageSpringScope");
     messageSpringScope1.setMessage("Hello how are you!!");
	  String message1=messageSpringScope.getMessage();
	  Assert.assertEquals(message1,"Hello how are you!!");
     Assert.assertNotNull("Object should not be null", messageSpringScope1);
     Assert.assertNotEquals("Hashcode values of each object should have different in prototype scope",messageSpringScope.hashCode(), messageSpringScope1.hashCode());
     log.debug(messageSpringScope.hashCode());
     log.debug(messageSpringScope1.hashCode());
	}
	
	
}
