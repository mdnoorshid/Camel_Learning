package com.bizruntime.personwebservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Person {
@WebMethod	
public String getName(@WebParam String getName);
@WebMethod
public int getId(@WebParam int id);
@WebMethod
public int getAge(@WebParam int age);
}
