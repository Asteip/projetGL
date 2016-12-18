
package com.alma.spring.rmi;

import java.util.List;


public interface StudentService {

	public void insertStudent(Student aStudent);

	public List<Student> getStudents();

}