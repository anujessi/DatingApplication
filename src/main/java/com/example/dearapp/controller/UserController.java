package com.example.dearapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dearapp.dto.MatchingUser;
import com.example.dearapp.entity.User;
import com.example.dearapp.responsestructure.ResponseStructure;
import com.example.dearapp.service.UserService;
import com.example.dearapp.util.UserGender;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	
	private UserService service;
	
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User u){
		return service.saveUser(u);
	}
	
	@GetMapping
	public ResponseStructure<List<User>>  findAllUsers(){
		return service.findAllUsers();
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseStructure<User>  findUserById(@PathVariable(name="id") Long id){
		
	
	return service.findUserById(id);
	}
	
	@GetMapping("/gender/male")
	public ResponseStructure<List<User>>  findAllMaleUsers(){
		return service.findAllMaleUsers();
	}
	
	@GetMapping("/gender/female")
	public ResponseStructure<List<User>> findAllFemaleUsers(){
		return service.findAllFemaleUsers();
	}
	
	@GetMapping("/role/admin")
	public ResponseStructure<List<User>> findAllAdmins(){
		return service.findAllAdmins();
	}
	
	
	
	@GetMapping("/status/inactive")
	public ResponseStructure<List<User>> findAllInactiveUser(){
		return service.findAllInactiveUser();
	}
	
	
	@GetMapping("/status/blocked")
	public ResponseStructure<List<User>> findAllBlockedUsers(){
		return service.findAllBlockedUsers();
	}
	@GetMapping("/status/deleted")
	public ResponseStructure<List<User>> findAllDeletedUsers(){
		return service.findAllDeletedUsers();
	}
	@PatchMapping("/status/inactive/{id}")
	
	public ResponseStructure<User> setStatusToInActive( @PathVariable(name="id")long id){
		return service.setStatusToInActive(id);
	}
	
	@PatchMapping("/status/deleted/{id}")
	public ResponseStructure<User> setStatusToDeleted(@PathVariable(name="id") long id){
		return service.setStatusToDeleted(id);
	}
	@PatchMapping("/status/blocked/{id}")
	public ResponseStructure<User> setStatusToBlocked(@PathVariable(name="id") long id){
		return service.setStatusToBlocked(id);
	}
	@PatchMapping("/status/active/{id}")
	public ResponseStructure<User> setStatusToActive(@PathVariable(name="id") long id){
		return service.setStatusToActive(id);
	}
	
	@PatchMapping("/status//terminated/{id}")
	public ResponseStructure<User> setStatusToTerminated(@PathVariable(name="id") long id){
		return service.setStatusToTerminated(id);
	}
	@GetMapping("/active/male")
	public ResponseStructure<List<User>> findAllActiveMaleUsers(){
		return service.findAllActiveMaleUsers();
	} 
	//***************************** to match the  male and female based on the  age and interest 2,3 ***************888
	
	@GetMapping("/matches/{id}/{top}")
	public ResponseStructure<List<MatchingUser>> findAllMatches( @PathVariable (name="id")Long id,@PathVariable(name="top") Integer top) {
		
		return service.findAllMatches(id,top);
	}
	
	// fetch user by role,
	// fetch by status, find by gender male only 

}
//finding user by role and status
//finding user by role
//finding 

   //active inactive