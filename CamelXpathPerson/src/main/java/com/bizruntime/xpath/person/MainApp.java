package com.bizruntime.xpath.person;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class MainApp {
	 public static void main(final String[] args) throws Exception {
		 new ClassPathXmlApplicationContext("camel-context.xml");
		 Thread.sleep(5000);
		 }
}


