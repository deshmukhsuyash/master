package com.aa.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aa.socialmedia.model.Inovoice;
import com.aa.socialmedia.model.User;


public interface InovoiceRepository extends CrudRepository<Inovoice, Integer> {

  
}