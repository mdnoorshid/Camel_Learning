package com.bizruntime.javaxmlwebservice;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;

@WebService
public class SimpleWebservice implements Simple 
{
static Logger log=Logger.getLogger(SimpleWebservice.class);
	@Override
	@WebMethod
	public String hello(@WebParam String s) {
		log.debug("Called Webservice with:: "+s);
		return "Hello "+s;
	}
}
