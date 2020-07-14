package com.aa.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.socialmedia.model.Inovoice;
import com.aa.socialmedia.service.User_Inovoice_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	
	@Autowired
	private User_Inovoice_Service inovoiceservice;
	
	
	@GetMapping("inovoice-list")
	public List<Inovoice> allinovoices() {
		  log.info("this is a info message");
		  log.warn("this is a warn message");
		  log.error("this is a error message");
		 return inovoiceservice.getInovoices();
	}
	
	
	@PostMapping("save-inovoice")
	public void saveInovoice(@RequestBody Inovoice inovoice) {
		 inovoiceservice.saveInovoices(inovoice);
		
	}
	
	@DeleteMapping("/delete-inovoice/{inovoice_number}")
	public void deleteInovoice(@PathVariable("inovoice_number") int inovoice_number,Inovoice inovoice) {
		 log.info("deleteInovoice");
		inovoice.setInovoice_number(inovoice_number);
		inovoiceservice.deleteInovoices(inovoice);
	}

	@PostMapping("update-inovoice/{inovoice_id}")
	public void updateInovoice(@RequestBody Inovoice inovoice,@PathVariable("inovoice_id") int inovoice_number) {
		 inovoice.setInovoice_number(inovoice_number);
		 inovoiceservice.updateInovoices(inovoice);
	}
	
}
