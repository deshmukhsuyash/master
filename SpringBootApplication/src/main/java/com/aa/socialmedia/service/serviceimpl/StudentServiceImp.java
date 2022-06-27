package com.aa.socialmedia.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.socialmedia.dao.StudentEntity;
import com.aa.socialmedia.model.Student;
import com.aa.socialmedia.repository.StudentRepository;
import com.aa.socialmedia.service.StudentService;
import com.aa.socialmedia.util.MapperUtil;

@Service
@Transactional
public class StudentServiceImp implements StudentService {

	private static final Logger log = LoggerFactory.getLogger(StudentServiceImp.class);

	@Autowired
	public StudentRepository repository;

	@Autowired
	public MapperUtil util;

	@Override
	public Student getStudentByID(Integer studentId) {
		StudentEntity result = repository.findById(studentId).get();

		if (result == null) {
			result = new StudentEntity();
		}
		return util.convert(result, Student.class);

	}

	@Override
	public List<Student> getStudents() {
		List<StudentEntity> resultList = repository.findAll();
		return resultList.stream().map(x -> util.convert(x, Student.class)).collect(Collectors.toList());

	}

	@Override
	public Page<Student> allStudentsPage(Pageable page) {
		Page<StudentEntity> resultList = repository.findAll(page);
		return util.mapEntityPageIntoModelPage(resultList, Student.class);

	}

	@Override
	public void saveStudent(StudentEntity student) {
		repository.save(student);
	}

	@Override
	public void deleteStudent(StudentEntity student) {
		log.info("Service deleteStudent");
		repository.delete(student);
	}

	@Override
	public void updateStudent(StudentEntity student) {

		StudentEntity result = repository.findById(student.getStudentId()).get();

		if (result == null) {
			result = new StudentEntity();
		}
		result.setStudentId(student.getStudentId());
		result.setStudentName(student.getStudentName());
		result.setStudentEmail(student.getStudentEmail());
		result.setStudentBranch(student.getStudentBranch());
		repository.save(result);

	}

}
