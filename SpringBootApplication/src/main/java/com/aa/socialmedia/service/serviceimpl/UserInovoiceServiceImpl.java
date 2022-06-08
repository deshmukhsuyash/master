package com.aa.socialmedia.service.serviceimpl;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.socialmedia.dao.InovoiceEntity;
import com.aa.socialmedia.model.Person;
import com.aa.socialmedia.model.ValidationFields;
import com.aa.socialmedia.repository.InovoiceRepository;
import com.aa.socialmedia.service.UserInovoiceService;

@Service
@Transactional
public class UserInovoiceServiceImpl implements UserInovoiceService {

	private static final Logger log = LoggerFactory.getLogger(UserInovoiceServiceImpl.class);

	@Autowired
	InovoiceRepository repository;

	@Override
	public List<InovoiceEntity> getInovoices() {
		return (List<InovoiceEntity>) repository.findAll();

	}

	@Override
	public void saveInovoices(InovoiceEntity inovoice) {
		repository.save(inovoice);
	}

	@Override
	public void deleteInovoices(InovoiceEntity inovoice) {
		log.info("Service deleteInovoice");
		repository.delete(inovoice);
	}

	@Override
	public void updateInovoices(InovoiceEntity inovoice) {

		InovoiceEntity result = repository.findById(inovoice.getInovoice_number()).get();

		if (result == null) {
			result = new InovoiceEntity();
		}

		result.setInovoice_number(inovoice.getInovoice_number());
		result.setInovoice_total(inovoice.getInovoice_total());
		result.setBill_date(inovoice.getBill_date());
		result.setBill_type(inovoice.getBill_type());
		repository.save(result);

	}

	@Override
	public String isValid(Person person, List<ValidationFields> fields) {
		String valid = "";
		try {
			for (ValidationFields propName : fields) {
				Object requiredValue = BeanUtils.getProperty(person, propName.getName());
				CharSequence inputStr = (CharSequence) requiredValue;
				Pattern pattern = Pattern.compile(propName.getExpression(), Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(inputStr);
				if (requiredValue != null && !isEmpty(requiredValue) && matcher.matches()) {
					log.info("Received valid " + propName);
					valid = "Validation completed Succesfully";
				} else {
					log.error("Received invalid customerId");
					valid = "Received wrong " + propName;
				}
			}
		} catch (Exception e) {
			log.error("Exception");
			e.printStackTrace();
			valid = "Error in Validation ";
		}
		return valid;
	}

}
