package com.bizruntime.xslt.student;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;

public class TestBean extends JFrame {
	static Logger log=Logger.getLogger(TestBean.class);
	String myBody;
	public void processGetHeader(Exchange exchange)
	{
	    myBody=(String) exchange.getIn().getHeader("myStud");
		
	}
	public void processGetBody(Exchange exchange)
	{
		try
		{
		JEditorPane ed1=new JEditorPane("text/html",myBody);
		add(ed1);
		setVisible(true);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		log.error("Some problem has occured"+e.getMessage());
		}

	}
}
