package com.bizruntime.testsoap;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;

public class GlobalWeatherService implements Provider<SOAPMessage>
{

	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		 // Requests should not come here as the Camel route will
        // intercept the call before this is invoked.
		throw new UnsupportedOperationException("Placeholder method");
	}

}
