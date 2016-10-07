package com.bizruntime.camel.restlet.camel;
import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import com.bizruntime.camel.restlet.customException.InvalidJson;
public class ConsumeJSON1 {
	static Logger log=Logger.getLogger(ConsumeJSON1.class);
	public void process(Exchange exchange) throws Exception
	{
		JSONObject jsonObject=null;
		String jsonValStr=exchange.getIn().getBody(String.class);
	   try{
		jsonObject=new JSONObject(jsonValStr);
	    String a=jsonObject.getString("a");
	    String b=jsonObject.getString("b");
	    log.debug("a Value---->"+a+"b Value---->"+b);
	    exchange.getOut().setBody("a Value---->"+a+"b Value---->"+b);
	   }catch(JSONException e)
	   {
		  /*throw new InvalidJson("Wrong JSON Format!!");*/
		   exchange.getOut().setBody(e.getMessage());
		   
	   }
	}

}
