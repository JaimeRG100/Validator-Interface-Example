package com.example.demo.validator;

import java.util.List;

public interface Validator<E> {
	
	public final static String IS_MISSING = " is missing. ";
	public final static String IS_REQUIRED = " is required. ";
	
	public List<String> validate(E classTarjet, String propertieName);

}