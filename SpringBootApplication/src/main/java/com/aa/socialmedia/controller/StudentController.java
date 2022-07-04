package com.aa.socialmedia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aa.socialmedia.dao.StudentEntity;
import com.aa.socialmedia.model.Employee;
import com.aa.socialmedia.model.FileRequest;
import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@PostMapping("save-student")
	public void saveStudent(@RequestBody StudentEntity student) {
		log.info("saveStudent");
		studentservice.saveStudent(student);

	}

	@PostMapping("save-studentfile")
	public StudentEntity saveStudentFile(@RequestPart("file") MultipartFile file,
			@RequestPart("data") StudentEntity student) {
		log.info("saveStudent");
		return studentservice.saveStudentFile(file, student);

	}

	@GetMapping("students-list")
	public List<Student> allstudents() {
		log.warn("allstudents");
		return studentservice.getStudents();
	}

	@GetMapping("students-page-list")
	public Page<Student> allstudentsPage(Pageable page) {
		log.warn("allstudents");
		return studentservice.allStudentsPage(page);
	}

	@DeleteMapping("delete-student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId, StudentEntity student) {
		log.info("deleteStudent");
		student.setStudentId(studentId);
		studentservice.deleteStudent(student);
	}

	@GetMapping("{studentId}")
	public Student getstudentByID(@PathVariable("studentId") Integer studentId) {
		log.info("allstudentByID");
		return studentservice.getStudentByID(studentId);

	}

	@GetMapping("downloadFile/{studentId}")
	public HttpEntity<byte[]> downloadStudentFile(@PathVariable("studentId") Integer studentId) {
		log.info("allstudentByID");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		FileRequest filereq = studentservice.getStudentFile(studentId);
		return new HttpEntity<>(filereq.getFileDetails(), headers);

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
