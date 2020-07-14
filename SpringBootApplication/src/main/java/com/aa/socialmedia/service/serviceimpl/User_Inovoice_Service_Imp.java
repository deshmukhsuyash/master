package com.aa.socialmedia.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.socialmedia.controller.Controller;
import com.aa.socialmedia.model.Inovoice;
import com.aa.socialmedia.repository.InovoiceRepository;
import com.aa.socialmedia.repository.UserRepository;
import com.aa.socialmedia.service.User_Inovoice_Service;

@Service
@Transactional
public class User_Inovoice_Service_Imp implements User_Inovoice_Service {
	
	private static final Logger log = LoggerFactory.getLogger(User_Inovoice_Service_Imp.class);
	
	@Autowired
	InovoiceRepository repository;
	
	@Override
	public List<Inovoice> getInovoices() {
		return (List<Inovoice>)repository.findAll();
		
	}
	
	  @Override public void saveInovoices(Inovoice inovoice) { 
		   repository.save(inovoice);
		  }
	  
	  
	  @Override public void deleteInovoices(Inovoice inovoice) {
		  log.info("Service deleteInovoice");
		   repository.delete(inovoice); 
		  }
	  
	  @Override public void updateInovoices(Inovoice inovoice) { 
		  
		   Inovoice result = repository.findById(inovoice.getInovoice_number()).get();
		  
		  if (result == null) {
	            result = new Inovoice();
	        }
		  
		  result.setInovoice_number(inovoice.getInovoice_number());
		  result.setInovoice_total(inovoice.getInovoice_total());
		  result.setBill_date(inovoice.getBill_date());
		  result.setBill_type(inovoice.getBill_type());
		  repository.save(result);
		  
		  }
	 
}
