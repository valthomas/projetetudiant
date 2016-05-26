package com.etu.Driver;

import javax.xml.ws.Endpoint;

import com.etu.Service.ExamenSoap;

public class DriverWebServiceExamen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://localhost:8092/";
		Endpoint.publish(url,new ExamenSoap());
		System.out.println(url);
	}

}
