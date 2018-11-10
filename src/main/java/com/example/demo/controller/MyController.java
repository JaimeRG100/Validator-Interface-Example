package com.example.demo.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Address;
import com.example.demo.domain.Person;
import com.example.demo.domain.Prescription;
import com.example.demo.validator.impl.PrescriptionValidator;

@RestController
@RequestMapping("/")
public class MyController {
	
	@Autowired
	private PrescriptionValidator prescriptionValidator;
	
	@PostMapping
	public Prescription postMethod(@RequestBody Prescription prescription) {
		List<String> finalValidationResult = prescriptionValidator.validate(prescription, "Prescription");
		
		if(finalValidationResult.size() > 0) {
			String message = finalValidationResult.stream().collect(Collectors.joining(","));
			throw new RuntimeException(message);
		}
		return prescription;
	}
	
	@GetMapping
	public Prescription getMethod() {
		Prescription prescription = new Prescription();
		prescription.setId(UUID.randomUUID());
		
		Person person = new Person();
		person.setName("Carlos");
		person.setLastName("Gonzalez");
		Address address = new Address();
		address.setStreet("Benito Juarez");
		address.setCity("Colima");
		person.setAddress(address );
		prescription.setPrescriber(person);
		
		Person person2 = new Person();
		person2.setName("Jose");
		person2.setLastName("Herrera");
		Address address2 = new Address();
		address2.setStreet("Miguel Hidalgo");
		address2.setCity("Villa de Alvarez");
		person2.setAddress(address );
		prescription.setPatient(person2);
		
		return prescription ;
	}

}
