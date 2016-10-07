package com.bizruntime.camel.restlet.camel;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

public class Calci_GET {
	static Logger log=Logger.getLogger(Calci_POST.class);
public void process(Exchange exchange)
{
	String headerVal=(String) exchange.getIn().getHeader("headerVal");
    String params = exchange.getIn().getHeader(Exchange.HTTP_QUERY, String.class);
    String [] paramArr=params.split("&");
    String aParam=paramArr[0];
    String bParam=paramArr[1];
    String [] aArr=aParam.split("=");
    String [] bArr=bParam.split("=");
    double a=  Double.parseDouble(aArr[1]);
    log.debug("a---------->"+a);
    double b=  Double.parseDouble(bArr[1]);
    log.debug("b---------->"+b);
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
