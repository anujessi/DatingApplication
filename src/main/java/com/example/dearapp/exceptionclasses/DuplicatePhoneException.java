package com.example.dearapp.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DuplicatePhoneException extends RuntimeException {
	
	private String message;
	public String getMessage() {
		return this.message;
	}
	

}
