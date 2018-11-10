package com.example.demo.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Address;
import com.example.demo.validator.Validator;

@Component ()
public class AddressValidator implements Validator<Address> {

	@Override
	public List<String> validate(Address addres, String propertieName) {
		List<String> validationResult = new ArrayList<>();
		
		// initial validation
		if (addres == null) {
			validationResult.add(propertieName + IS_REQUIRED);
			return validationResult;
		}
		
		// internal validation
		if(addres.getStreet()==null || addres.getStreet().isEmpty())
			validationResult.add(propertieName + ".street "+ IS_MISSING);
		if(addres.getCity()==null || addres.getCity().isEmpty())
			validationResult.add(propertieName + ".city "+ IS_MISSING);
		
		// external validation 
		
		return validationResult;
	}
	

}
