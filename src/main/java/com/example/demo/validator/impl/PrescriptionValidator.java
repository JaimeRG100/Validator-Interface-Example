package com.example.demo.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Prescription;
import com.example.demo.validator.Validator;

@Component
public class PrescriptionValidator implements Validator<Prescription> {
	
	@Autowired
	private PersonValidator personValidator;

	@Override
	public List<String> validate(Prescription prescription, String propertieName) {
		System.err.println("PrescriptionValidator running ... " + propertieName);
		List<String> validationResult = new ArrayList<>();
		
		// initial validation
		if (prescription == null) {
			validationResult.add(propertieName + IS_REQUIRED);
			return validationResult;
		}
		
		// internal validation
		if(prescription.getId() == null )
			validationResult.add(propertieName + ".id "+ IS_MISSING);
		
		// external validation
		validationResult.addAll(personValidator.validate(prescription.getPatient(), propertieName + "/Patient"));
		validationResult.addAll(personValidator.validate(prescription.getPrescriber(), propertieName + "/Prescriber"));
		
		return validationResult;
	}

}
