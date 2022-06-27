package com.aa.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.socialmedia.dao.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}