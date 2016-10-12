package com.bizruntime.routecalled;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.log4j.Logger;
import org.json.JSONObject;

//camel-route-called
public class RouteCalled 
{
	JSONObject jsonObject=null;
static Logger log=Logger.getLogger(RouteCalled.class);
	@Handler
public void getJson(Exchange exchange)
{
		/*String jsonStr=exchange.getIn().getBody(String.class);   
		  jsonObject=new JSONObject(jsonStr);
		  int a=Integer.parseInt(jsonObject.getString("a"));
		  int b=Integer.parseInt(jsonObject.getString("b"));
		  log.debug("Values from route caller Sum is----->"+(a+b));*/
		   String body=exchange.getIn().getBody(String.class);
	   	   log.debug("Body Recived in routeCalled:::"+body);
	     
}
}
