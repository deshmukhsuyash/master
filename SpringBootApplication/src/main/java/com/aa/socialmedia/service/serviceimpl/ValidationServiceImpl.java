package com.aa.socialmedia.service.serviceimpl;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.aa.socialmedia.model.Person;
import com.aa.socialmedia.model.ValidationFields;
import com.aa.socialmedia.model.ValidationRequest;
import com.aa.socialmedia.service.ValidationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidationServiceImpl implements ValidationService {

	@Override
	public List<String> isValid(ValidationRequest request) {
		List<String> valid = new ArrayList<>();
		try {
			for (ValidationFields propName : request.getFields()) {
				Object requiredValue = BeanUtils.getProperty(request.getPerson(), propName.getName());
				CharSequence inputStr = (CharSequence) requiredValue;
				Pattern pattern = Pattern.compile(propName.getExpression(), Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(inputStr);
				if (requiredValue != null && !isEmpty(requiredValue) && matcher.matches()) {
					log.info("Received valid {} ", propName);
				} else {
					log.info("Received invalid {}", propName);
					valid.add("Received invalid " + propName);

				}
			}
		} catch (Exception e) {
			log.error("Exception");
			e.printStackTrace();
			valid.add("Error in Validation ");
		}
		if (valid.isEmpty())
			valid.add("Validation Completed Sussefully");
		return valid;
	}

	@Override
	public ValidationRequest getPersonJson() {
		ValidationFields field1 = new ValidationFields("name", "^[A-Za-z][A-Za-z0-9_]{7,29}$");
		ValidationFields field2 = new ValidationFields("phoneNumber", "(0/91)?[7-9][0-9]{9}");
		List<ValidationFields> fields = new ArrayList<>();
		fields.add(field1);
		fields.add(field2);
		return ValidationRequest.builder()
				.person(Person.builder().customerId(10).name("SUYASHDE").phoneNumber("9800088899").build())
				.fields(fields).build();

	}

}
