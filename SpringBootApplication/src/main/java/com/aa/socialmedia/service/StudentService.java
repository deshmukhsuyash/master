package com.aa.socialmedia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.aa.socialmedia.dao.StudentEntity;
import com.aa.socialmedia.model.FileRequest;
import com.aa.socialmedia.model.Student;

public interface StudentService {

	public Student getStudentByID(Integer studentId);

	public StudentEntity saveStudent(StudentEntity student);

	public StudentEntity saveStudentFile(MultipartFile file, StudentEntity student);

	public List<Student> getStudents();

	public Page<Student> allStudentsPage(Pageable page);

	public void deleteStudent(StudentEntity student);

	public void updateStudent(StudentEntity student);

	public FileRequest getStudentFile(Integer studentId);

}
