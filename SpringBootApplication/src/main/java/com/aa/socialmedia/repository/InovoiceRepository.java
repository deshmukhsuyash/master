package com.aa.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.socialmedia.dao.InovoiceEntity;

@Repository
public interface InovoiceRepository extends JpaRepository<InovoiceEntity, Integer> {

}