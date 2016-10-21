package com.bizruntime.spring.ioc.callmethoddirectly;
public class JavaBean {

public static String getStaticName(String name){
	return name;
}
public CallNonStatic getNonStaticName(String name){
	return new CallNonStatic();
}
}
