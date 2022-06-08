package com.aa.socialmedia.service;

import java.util.List;

import com.aa.socialmedia.dao.StudentEntity;

public interface StudentService {

	public StudentEntity getStudentByID(StudentEntity student);

	public void saveStudent(StudentEntity student);

	public List<StudentEntity> getStudents();

	public void deleteStudent(StudentEntity student);

	public void updateStudent(StudentEntity student);

}
