package com.alma.app.rmi;
import java.io.Serializable;


public class Student implements Serializable {

	private static final long serialVersionUID = 7950662004399204703L;

	private String id;
	private String name;
	
	public Student(String anID, String aName) {
		id = anID;
		name = aName;
	}

	public String toString() {
		return "Name: " + name + " ID: "+ id;
	}

}