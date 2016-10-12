package com.bizruntime.testsoap;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;


public class TestBean 
{
   static Logger log=Logger.getLogger(TestBean.class);
	 // Since the Camel-CXF endpoint uses a list to store the parameters
    // and bean component uses the bodyAs expression to get the value
    // we'll need to deal with the parameters ourself
	public SOAPMessage processSOAP(Exchange exchange)
	{
		  SOAPMessage soapMessage = (SOAPMessage)exchange.getIn().getBody(List.class).get(0);
		  if (soapMessage == null) {
	            System.out.println("Incoming null message detected...");
	            return createDefaultSoapMessage("Greetings from Apache Camel!!!!", "null");
	        }
	 
	        try {
	            SOAPPart sp = soapMessage.getSOAPPart();
	            SOAPEnvelope se = sp.getEnvelope();
	            SOAPBody sb = se.getBody();
	            String requestText = sb.getFirstChild().getTextContent();
	            System.out.println(requestText);
	            return createDefaultSoapMessage("Greetings from Apache Camel!!!!", requestText);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return createDefaultSoapMessage("Greetings from Apache Camel!!!!", e.getClass().getName());
	        }
	}
	 public static SOAPMessage createDefaultSoapMessage(String responseMessage, String requestMessage) {
	        try {
	            SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
	            SOAPBody body = soapMessage.getSOAPPart().getEnvelope().getBody();
	 
	            QName payloadName = new QName("http://www.webservicex.net/globalweather.asmx", "greetMeResponse", "ns1");
	 
	            SOAPBodyElement payload = body.addBodyElement(payloadName);
	 
	            SOAPElement message = payload.addChildElement("responseType");
	 
	            message.addTextNode(responseMessage + " Request was  " + requestMessage);
	            return soapMessage;
	        } catch (SOAPException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	    }
}
