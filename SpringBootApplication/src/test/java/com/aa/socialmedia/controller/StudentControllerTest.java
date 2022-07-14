package com.aa.socialmedia.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.service.StudentService;

@SpringBootTest
class StudentControllerTest {

	@Autowired
	private StudentController controller;

	@MockBean
	private StudentService studentService;

	@Test
	void test() {
		Student st = new Student();
		st.setStudentName("Abcd");
		st.setStudentEmail("xml@gmail.com");
		st.setStudentBranch("Computer");
		Mockito.when(studentService.getStudentByID(ArgumentMatchers.any())).thenReturn(st);
		Student student = controller.getstudentByID(10);
		Assertions.assertNotNull(student);

		Assertions.assertEquals("Abcd", student.getStudentName());
	}

}
