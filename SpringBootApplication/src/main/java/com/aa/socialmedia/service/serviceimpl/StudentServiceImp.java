package com.aa.socialmedia.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.socialmedia.controller.Controller;
import com.aa.socialmedia.model.Inovoice;
import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.repository.InovoiceRepository;
import com.aa.socialmedia.repository.StudentRepository;
import com.aa.socialmedia.repository.UserRepository;
import com.aa.socialmedia.service.StudentService;
import com.aa.socialmedia.service.User_Inovoice_Service;

@Service
@Transactional
public class StudentServiceImp implements StudentService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImp.class);
	
	@Autowired
	StudentRepository repository;
	
	@Override
	public Student getStudentByID(Student student) {
		 Student result =repository.findById(student.getStudent_id()).get();
		 
		 if (result == null) {
	            result = new Student();
	        }
		 
		 return result;
	}

	
	@Override
	public List<Student> getStudents() {
		return (List<Student>)repository.findAll();
		
	}
	
	  @Override 
	  public void saveStudent(Student student) { 
		   repository.save(student);
		  }
	   
	  @Override public void deleteStudent(Student student) {
		  log.info("Service deleteStudent");
		   repository.delete(student); 
		  }
	  
	  @Override public void updateStudent(Student student) { 
		  
		  Student result = repository.findById(student.getStudent_id()).get();
		  
		  if (result == null) {
	            result = new Student();
	        }
		   result.setStudent_id(student.getStudent_id());
		   result.setStudent_name(student.getStudent_name());
		   result.setStudent_email(student.getStudent_email());
		   result.setStudent_branch(student.getStudent_branch());
		  repository.save(result);
		  
		  }
	 
}
