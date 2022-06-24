package com.aa.socialmedia.service;

import java.util.List;

import com.aa.socialmedia.dao.StudentEntity;
import com.aa.socialmedia.model.Student;

public interface StudentService {

	public Student getStudentByID(Integer studentId);

	public void saveStudent(StudentEntity student);

	public List<StudentEntity> getStudents();

	public void deleteStudent(StudentEntity student);

	public void updateStudent(StudentEntity student);

}
