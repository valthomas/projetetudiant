package com.etu.Driver;

import javax.xml.ws.Endpoint;

import com.etu.Service.SessionSoap;

public class DriverWebServiceSession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://localhost:8092/";
		Endpoint.publish(url,new SessionSoap());
		System.out.println(url);
	}

}
