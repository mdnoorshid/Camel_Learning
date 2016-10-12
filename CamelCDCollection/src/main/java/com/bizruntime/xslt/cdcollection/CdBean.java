package com.bizruntime.xslt.cdcollection;
import java.io.FileNotFoundException;
import javax.swing.*;

import org.apache.camel.Exchange;

public class CdBean extends JFrame
{
	String html;
public void getHeader(Exchange exchange)
{
 html=(String) exchange.getIn().getHeader("myCdHeader");
}
public void getBody(Exchange exchange) throws FileNotFoundException
{
	try
	{
	JEditorPane ed1=new JEditorPane("text/html",html);
	add(ed1);
	setVisible(true);
	setSize(1366,768);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Some problem has occured"+e.getMessage());
	}
}
}
