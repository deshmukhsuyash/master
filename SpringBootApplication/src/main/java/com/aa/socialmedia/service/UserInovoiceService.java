package com.aa.socialmedia.service;

import java.util.List;

import com.aa.socialmedia.dao.InovoiceEntity;
import com.aa.socialmedia.model.Person;
import com.aa.socialmedia.model.ValidationFields;

public interface UserInovoiceService {

	public List<InovoiceEntity> getInovoices();

	public void saveInovoices(InovoiceEntity inovoice);

	public void deleteInovoices(InovoiceEntity inovoice);

	public void updateInovoices(InovoiceEntity inovoice);

	public String isValid(Person person, List<ValidationFields> fields);

}
