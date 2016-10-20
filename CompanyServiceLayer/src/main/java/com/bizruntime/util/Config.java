package com.bizruntime.util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config 
{
	String result = "";
	InputStream inputStream;
 
	public String getPropValues(String key) throws IOException, InputStreamNullException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundExc("property file '" + propFileName + "' not found in the classpath");
			}
			String keyVal = prop.getProperty(key);
			result=keyVal;
		} catch (Exception e) {
			throw new InputStreamNullException("Inputstream is null!!",e);
		} finally {
			inputStream.close();
		}
		return result;
	}
	public static void main(String[] args) throws IOException, InputStreamNullException 
	{
	
	System.out.println(new Config().getPropValues("USER"));
		
	}
	
}
