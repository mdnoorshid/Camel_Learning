package com.bizruntime.camel.restlet.camel;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class Calci_POST 
{
	static Logger log=Logger.getLogger(Calci_POST.class);
	JSONObject jsonObject=null;
public void process(Exchange exchange)
{
	String headerVal=(String) exchange.getIn().getHeader("headerVal");
    String jsonValStr=exchange.getIn().getBody(String.class);
    jsonObject=new JSONObject(jsonValStr);
    double a=Double.parseDouble(jsonObject.getString("a"));
    double b=Double.parseDouble(jsonObject.getString("b"));
	
	if(headerVal.equalsIgnoreCase("add"))
	{
		double sum=a+b;
		log.debug("sum is:::"+sum);
		exchange.getOut().setBody("sum is:::"+sum);
		
	}
	if(headerVal.equalsIgnoreCase("subtract"))
	{
		double subtract=a-b;
		log.debug("subtraction is:::"+subtract);
		exchange.getOut().setBody("subtraction is:::"+subtract);
		
	}
	if(headerVal.equalsIgnoreCase("multi"))
	{
		double multi=a*b;
		log.debug("Multiplication is:::"+multi);
		exchange.getOut().setBody("Multiplication is:::"+multi);
		
	}
	if(headerVal.equalsIgnoreCase("divide"))
	{
		double divie=a+b;
		log.debug("Division is:::"+divie);
		exchange.getOut().setBody("Division is:::"+divie);
		
	}

}
}
