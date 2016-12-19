
package com.alma.app.rmi;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements StudentService {

	List<Student> students = new ArrayList<Student>();

	public void insertStudent(Student acc) {
		students.add(acc);
	}

	public List<Student> getStudents() {
		return students;
	}

}