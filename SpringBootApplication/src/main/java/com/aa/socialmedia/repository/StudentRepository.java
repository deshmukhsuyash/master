package com.aa.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.aa.socialmedia.dao.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}