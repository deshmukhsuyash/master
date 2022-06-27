package com.aa.socialmedia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aa.socialmedia.dao.StudentEntity;
import com.aa.socialmedia.model.Student;

public interface StudentService {

	public Student getStudentByID(Integer studentId);

	public void saveStudent(StudentEntity student);

	public List<Student> getStudents();

	public Page<Student> allStudentsPage(Pageable page);

	public void deleteStudent(StudentEntity student);

	public void updateStudent(StudentEntity student);

}
