package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	
	private String name; //mandatory
	private String lastName; //mandatory
	private Address address; //mandatory

}
