package com.alma.app.rmi;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
		StudentService as = (StudentService) context.getBean("studentBean");

		Student a = new Student("A", "Alice");
		as.insertStudent(a);

		Student b = new Student("B", "Bob");
		as.insertStudent(b);

		List<Student> accounts = as.getStudents();
		for (Student each : accounts) {
			System.out.println(each);
		}

	}
}
