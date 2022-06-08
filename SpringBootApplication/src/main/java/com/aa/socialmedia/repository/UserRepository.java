package com.aa.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.aa.socialmedia.dao.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}