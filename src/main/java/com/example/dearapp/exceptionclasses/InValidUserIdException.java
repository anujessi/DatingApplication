package com.example.dearapp.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InValidUserIdException extends RuntimeException {
	private String message;
	public String getMessage() {
		return this.message;
	}

}
