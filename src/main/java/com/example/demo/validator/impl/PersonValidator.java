package com.example.demo.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Person;
import com.example.demo.validator.Validator;

@Component
public class PersonValidator implements Validator<Person>{
	
	@Autowired
	private AddressValidator addressValidator;

	@Override
	public List<String> validate(Person person, String propertieName) {
		List<String> validationResult = new ArrayList<>();
		// initial validation
		if(person == null) {
			validationResult.add(propertieName + IS_REQUIRED);
			return validationResult;
		}
		
		// internal validation
		if(person.getName()==null || person.getName().isEmpty())
			validationResult.add(propertieName + ".name "+ IS_MISSING);
		if(person.getLastName()==null || person.getLastName().isEmpty())
			validationResult.add(propertieName + ".lastName "+ IS_MISSING);
		
		// external validation
		
		validationResult.addAll(addressValidator.validate(person.getAddress(), propertieName + "/Address"));
//		List<String> result2 = addressValidator.validate(person.getAddress(), propertieName + "/Address");
//		validationResult.addAll(result2);
		
		
		return validationResult;
	}

}
