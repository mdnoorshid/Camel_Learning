package com.bizruntime.camelxpath.employee;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.log4j.Logger;

public class EmployeeBean 
{
static Logger log=Logger.getLogger(EmployeeBean.class);	
public void processEmployee(Exchange exhchange) throws Exception {
	String employee=(String) exhchange.getIn().getHeader("employee");
	log.debug("Result(Java)---------->"+employee);	
}
}
