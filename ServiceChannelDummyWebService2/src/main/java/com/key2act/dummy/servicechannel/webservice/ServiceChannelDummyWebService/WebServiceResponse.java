package com.key2act.dummy.servicechannel.webservice.ServiceChannelDummyWebService;

import org.apache.camel.Exchange;
import org.restlet.data.MediaType;

public class WebServiceResponse {
public void getRespose(Exchange exchange){
	exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_WWW_FORM);
	exchange.getIn().setBody("OK");
}
}
