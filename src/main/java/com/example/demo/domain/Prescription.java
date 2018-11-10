package com.example.demo.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
	
	private UUID id;
	private Person patient;
	private Person prescriber;

}
