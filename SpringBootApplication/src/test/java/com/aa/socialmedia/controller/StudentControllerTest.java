package com.aa.socialmedia.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aa.socialmedia.model.Student;

@SpringBootTest
class StudentControllerTest {

	@Autowired
	private StudentController controller;

	@Test
	void test() {
		Student student = controller.getstudentByID(2);
		Assertions.assertNotNull(student);

		Assertions.assertEquals("Abc", student.getStudentName());
	}

}
