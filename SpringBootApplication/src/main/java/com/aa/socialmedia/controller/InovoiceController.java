package com.aa.socialmedia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.socialmedia.dao.InovoiceEntity;
import com.aa.socialmedia.model.Person;
import com.aa.socialmedia.model.ValidationFields;
import com.aa.socialmedia.model.ValidationRequest;
import com.aa.socialmedia.service.UserInovoiceService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api")
public class InovoiceController {

	private static final Logger log = LoggerFactory.getLogger(InovoiceController.class);

	@Autowired
	private UserInovoiceService inovoiceservice;

	@GetMapping("inovoice-list")
	public List<InovoiceEntity> allinovoices() {
		log.info("this is a info message");
		log.warn("this is a warn message");
		log.error("this is a error message");
		return inovoiceservice.getInovoices();
	}

	@PostMapping("validate-inovoice")
	public String create(@Valid @RequestBody ValidationRequest request) {
		ValidationFields field1 = new ValidationFields("name", "^[A-Za-z][A-Za-z0-9_]{7,29}$");
		ValidationFields field2 = new ValidationFields("phoneNumber", "(0/91)?[7-9][0-9]{9}");
		List<ValidationFields> fields = new ArrayList<>();
		fields.add(field1);
		fields.add(field2);
		ValidationRequest request1 = ValidationRequest.builder()
				.person(Person.builder().customerId(10).name("SUYASH").phoneNumber("1234567").build()).fields(fields)
				.build();

		return inovoiceservice.isValid(request.getPerson(), request.getFields());

	}

	@PostMapping("save-inovoice")
	public void saveInovoice(@RequestBody InovoiceEntity inovoice) {
		inovoiceservice.saveInovoices(inovoice);

	}

	@DeleteMapping("/delete-inovoice/{inovoice_number}")
	public void deleteInovoice(@PathVariable("inovoice_number") int inovoice_number, InovoiceEntity inovoice) {
		log.info("deleteInovoice");
		inovoice.setInovoice_number(inovoice_number);
		inovoiceservice.deleteInovoices(inovoice);
	}

	@PostMapping("update-inovoice/{inovoice_id}")
	public void updateInovoice(@RequestBody InovoiceEntity inovoice, @PathVariable("inovoice_id") int inovoice_number) {
		inovoice.setInovoice_number(inovoice_number);
		inovoiceservice.updateInovoices(inovoice);
	}

}
