package com.aa.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.socialmedia.model.Inovoice;
import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.service.StudentService;
import com.aa.socialmedia.service.User_Inovoice_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	
	@Autowired
	private StudentService studentservice ;
	
	
	@PostMapping("save-student")
	public void saveStudent(@RequestBody Student student) {
		 log.info("saveStudent");
		 studentservice.saveStudent(student);
		
	}
	
	@GetMapping("students-list")
	public List<Student> allstudents() {
		  log.info("allstudents");
		 return studentservice.getStudents();
	}
	
	
	@DeleteMapping("delete-student/{student_id}")
	public void deleteStudent(@PathVariable("student_id") int student_id,Student student) {
		  log.info("deleteStudent");
		 student.setStudent_id(student_id);
		 studentservice.deleteStudent(student);
	}

	
	  @GetMapping("student/{student_id}") 
	  public Student allstudentByID(@PathVariable("student_id") int student_id,Student student) 
	  { log.info("allstudentByID");
	  student.setStudent_id(student_id);
	  return studentservice.getStudentByID(student);
	   
	  }
	 
	
	@PostMapping("update-student/{student_id}")
	public void updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
		 log.info("updateStudent");
		 student.setStudent_id(student_id);
		 studentservice.updateStudent(student);
	}
}
