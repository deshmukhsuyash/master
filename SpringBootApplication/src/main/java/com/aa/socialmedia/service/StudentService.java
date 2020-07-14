package com.aa.socialmedia.service;

import java.util.List;

import com.aa.socialmedia.model.Inovoice;
import com.aa.socialmedia.model.Student;

public interface StudentService {

	public Student getStudentByID(Student student);
	public void saveStudent(Student student);
	public List<Student> getStudents();
	public void deleteStudent(Student student);
	public void updateStudent(Student student);
	
}
