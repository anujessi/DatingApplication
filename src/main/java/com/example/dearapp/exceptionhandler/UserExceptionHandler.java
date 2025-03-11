package com.example.dearapp.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dearapp.exceptionclasses.DuplicateEmailIdException;
import com.example.dearapp.exceptionclasses.DuplicatePhoneException;
import com.example.dearapp.exceptionclasses.InValidUserIdException;
import com.example.dearapp.responsestructure.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler  {
	
@ExceptionHandler(DuplicateEmailIdException.class)
public ResponseStructure<String> duplicateEmailIdException (DuplicateEmailIdException  e){
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setMessage("Already account exist for this specific email");
	structure.setBody(e.getMessage());
	return structure;
	
}
@ExceptionHandler(DuplicatePhoneException.class)
public ResponseStructure<String> duplicatePhoneException(DuplicatePhoneException e){
	ResponseStructure<String> structure= new ResponseStructure<>();
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setMessage("Alredy account exist for this specific phone");
	structure.setBody(e.getMessage());
	return structure;
}
@ExceptionHandler(InValidUserIdException.class)
public ResponseStructure<String> inValidUserIdException(InValidUserIdException e){
	ResponseStructure<String> structure= new ResponseStructure<>();
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setMessage("invalid id it is not present");
	structure.setBody(e.getMessage());
	return structure;
}


}
