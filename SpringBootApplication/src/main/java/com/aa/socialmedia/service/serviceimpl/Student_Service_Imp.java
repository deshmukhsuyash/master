package com.aa.socialmedia.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.socialmedia.dao.Student_DAO;
import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.service.Student_Service;

@Service
@Transactional
public class Student_Service_Imp implements Student_Service {
 
	@Autowired
	private Student_DAO studentdao;
	
	@Override
	public boolean saveStudent(Student student) {
		return studentdao.saveStudent(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentdao.getStudents();
	}

	@Override
	public boolean deleteStudent(Student student) {
		return studentdao.deleteStudent(student);
	}

	@Override
	public List<Student> getStudentByID(Student student) {
		return studentdao.getStudentByID(student);
	}

	@Override
	public boolean updateStudent(Student student) {
		return studentdao.updateStudent(student);
	}

}
