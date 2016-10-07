package com.bizruntime.camel.restlet.camel;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsumeJSON2 {
	static Logger log=Logger.getLogger(ConsumeJSON2.class);
	public void process(Exchange exchange)
	{
		JSONObject jsonObject=null;
		String jsonValStr=exchange.getIn().getBody(String.class);
	   try{
		jsonObject=new JSONObject(jsonValStr);
	    String a=jsonObject.getString("a");
	    String b=jsonObject.getString("b");
	    log.debug("a Value---->"+a+"b Value---->"+b);
	    exchange.getOut().setBody("a Value---->"+a+"b Value---->"+b);
	}
	   catch(JSONException e)
	   {
		   exchange.getOut().setBody("You have posted wrong json,please give right json");
		   exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE,new Integer(400));
	   }
}
}