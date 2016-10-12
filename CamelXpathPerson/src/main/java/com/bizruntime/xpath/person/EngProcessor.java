package com.bizruntime.xpath.person;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class EngProcessor implements Processor {
     static Logger log=Logger.getLogger(EngProcessor.class);
	public void process(Exchange exchange) throws Exception {

		log.debug("inside the Engineering Processor");
	}

}