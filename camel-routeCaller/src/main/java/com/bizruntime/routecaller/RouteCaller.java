package com.bizruntime.routecaller;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.log4j.Logger;
import org.json.JSONObject;
public class RouteCaller {
	
static Logger log=Logger.getLogger(RouteCaller.class);	
//camel-route caller	
	JSONObject jsonObject=null;
	    @Handler
public void bodyProcess(Exchange exchange)
{
  /*String jsonStr=exchange.getIn().getBody(String.class);   
  jsonObject=new JSONObject(jsonStr);
  int a=Integer.parseInt(jsonObject.getString("a"));
  int b=Integer.parseInt(jsonObject.getString("b"));
  log.debug("Values from route caller----->"+a+" , "+b);*/
  /*String valueReceived=exchange.getIn().getBody(String.class);*/
  /*log.debug("Body recieved in routeCaller::: "+valueReceived);*/
	    	/*exchange.getIn().setBody(exchange.getIn().getBody());*/
}
}
