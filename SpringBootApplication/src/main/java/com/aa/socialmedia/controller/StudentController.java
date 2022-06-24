package com.aa.socialmedia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.socialmedia.dao.StudentEntity;
import com.aa.socialmedia.model.Employee;
import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@PostMapping("save-student")
	public void saveStudent(@RequestBody StudentEntity student) {
		log.info("saveStudent");
		studentservice.saveStudent(student);

	}

	@GetMapping("students-list")
	public List<StudentEntity> allstudents() {
		log.warn("allstudents");
		return studentservice.getStudents();
	}

	@DeleteMapping("delete-student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId, StudentEntity student) {
		log.info("deleteStudent");
		student.setStudentId(studentId);
		studentservice.deleteStudent(student);
	}

	@GetMapping("student/{studentId}")
	public Student allstudentByID(@PathVariable("studentId") Integer studentId) {
		log.info("allstudentByID");
		return studentservice.getStudentByID(studentId);

	}

	@PostMapping("update-student/{studentId}")
	public void updateStudent(@RequestBody StudentEntity student, @PathVariable("studentId") int studentId) {
		log.info("updateStudent");
		student.setStudentId(studentId);
		studentservice.updateStudent(student);
	}

	@PostMapping("validate-employee")
	public Employee create(@Valid @RequestBody Employee employee) {

		return employee;

	}
}
