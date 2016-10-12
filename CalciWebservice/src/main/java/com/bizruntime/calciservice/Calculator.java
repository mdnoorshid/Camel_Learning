package com.bizruntime.calciservice;

import javax.jws.WebService;

@WebService(targetNamespace = "http://calciServ.camel.bizruntime.com/", portName = "CalciServicePort", serviceName = "CalciServiceService")
public class Calculator {
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	public double subtract(double num1, double num2) {
		return num1-num2;
	}
	public double multiply(double num1, double num2) {
		return num1*num2;
	}
	public double divide(double num1, double num2) {
		return num1/num2;
	}
}