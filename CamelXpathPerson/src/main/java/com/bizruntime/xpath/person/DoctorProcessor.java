package com.bizruntime.xpath.person;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.log4j.Logger;

public class DoctorProcessor implements Processor {
  static Logger log=Logger.getLogger(DoctorProcessor.class);
	public void process(Exchange exchange) throws Exception {
		
		log.debug("inside doctor");
		GenericFile genericFile = (GenericFile) exchange.getIn().getBody();   
		log.debug("  -----------   "+genericFile);
	}

}