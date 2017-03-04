package com.key2act.dummy.servicechannel.webservice.ServiceChannelDummyWebService;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.BasicConfigurator;

public class WebserviceServiceChannelClient {
  static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(WebserviceServiceChannelClient.class);
public String getResponse(){
	String url="http://localhost:8431/serviceChannelDummyWebservice";
	HttpGet httpGet=new HttpGet(url);
	HttpClient httpClient=HttpClientBuilder.create().build();
	String reponse=null;
	HttpResponse httpResponse;
	try {
		httpResponse = httpClient.execute(httpGet);
	int statusCode=httpResponse.getStatusLine().getStatusCode();
	logger.debug("statusCode:: "+statusCode);
	HttpEntity httpEntity=httpResponse.getEntity();
	if(httpEntity!=null){
		reponse=EntityUtils.toString(httpEntity);
		   logger.debug("response::"+reponse);
		}

	}catch (IOException e) {
	}
	return reponse;
}
public static void main(String[] args) {
	BasicConfigurator.configure();
	new WebserviceServiceChannelClient().getResponse();
}
}
