package com.alma.app.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ServerLauncher {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("server-beans.xml");
		System.out.println("Waiting for requests");
	}
}
