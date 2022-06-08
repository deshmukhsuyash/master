package com.aa.socialmedia.util;

import static org.springframework.util.StringUtils.isEmpty;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConditionalValidator implements ConstraintValidator<Conditional, Object> {

	// private String selected;
	private String[] required;
	private String message;
	// private String[] values;

	@Override
	public void initialize(Conditional requiredIfChecked) {
		// selected = requiredIfChecked.selected();
		required = requiredIfChecked.required();
		message = requiredIfChecked.message();
		// values = requiredIfChecked.values();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		Boolean valid = true;
		try {
			// Object checkedValue = BeanUtils.getProperty(object, selected);
			for (String propName : required) {
				Object requiredValue = BeanUtils.getProperty(object, propName);
				valid = requiredValue != null && !isEmpty(requiredValue);
				System.out.println("value: " + "" + requiredValue);
				if (!valid) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(message).addPropertyNode(propName)
							.addConstraintViolation();
				}
			}

		} catch (IllegalAccessException e) {
			log.error("Accessor method is not available for class : {}, exception : {}", object.getClass().getName(),
					e);
			e.printStackTrace();
			return false;
		} catch (NoSuchMethodException e) {
			log.error("Field or method is not present on class : {}, exception : {}", object.getClass().getName(), e);
			e.printStackTrace();
			return false;
		} catch (InvocationTargetException e) {
			log.error("An exception occurred while accessing class : {}, exception : {}", object.getClass().getName(),
					e);
			e.printStackTrace();
			return false;
		}
		return valid;
	}
}
