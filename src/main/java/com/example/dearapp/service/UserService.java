package com.example.dearapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.dearapp.dao.UserDao;
import com.example.dearapp.dto.MatchingUser;
import com.example.dearapp.entity.User;
import com.example.dearapp.exceptionclasses.DuplicateEmailIdException;
import com.example.dearapp.exceptionclasses.DuplicatePhoneException;
import com.example.dearapp.exceptionclasses.InValidUserIdException;
import com.example.dearapp.responsestructure.ResponseStructure;
import com.example.dearapp.util.SortByAgeDifferenceAsc;
import com.example.dearapp.util.UserGender;
import com.example.dearapp.util.UserRole;
import com.example.dearapp.util.UserStatus;

@Service

public class UserService {
	@Autowired
	private   UserDao dao;

	public ResponseStructure<User> saveUser(User u) {
		Optional <User> optional= dao.findByPhone(u.getPhone());
		Optional<User> optional1 =dao.findByEmail(u.getEmail());
		if(optional1.isPresent()) {
			throw new DuplicateEmailIdException("Account already exist with this email can you please create with another Email"+u.getEmail());
				
		}
		if(optional.isPresent()) {
			throw  new DuplicatePhoneException("Account already exist with this phone can you please create with another mobileNumber"+" "+u.getPhone());
		}
	u =dao.saveUser(u);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("User Saved successfully");
		structure.setBody(u);
		return structure;
	}

	public ResponseStructure<List<User>> findAllUsers() {
		
		 List<User> u=dao.findAllUsers();
		 
		 ResponseStructure<List<User> >structure=new ResponseStructure<>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("All users found Successfully");
			structure.setBody(u);
			return structure;
	}

	public ResponseStructure<User> findUserById(Long id) {
	Optional<User> optional   =	dao.findUserById(id);
	if(optional.isEmpty()) {
		throw new InValidUserIdException("This id is not present unable to find"+id+"this user not there");
	}
		 ResponseStructure <User> structure=new ResponseStructure<>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage(" user found Successfully");
			structure.setBody(optional.get());
			return structure;
		
	}

	public ResponseStructure<List<User>> findAllMaleUsers() {
		
		List<User> maleUsers=dao.findAllMaleUsers(UserGender.MALE);
		 ResponseStructure<List<User> >structure=new ResponseStructure<>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("All  male users found Successfully");
			structure.setBody(maleUsers);
			return structure;
	
		
	}

	public ResponseStructure<List<User>> findAllFemaleUsers() {
	List<User> femaleUser=	dao.findAllFemaleUsers(UserGender.FEMALE);
	ResponseStructure<List<User>>  structure = new ResponseStructure<>();
	structure.setStatus(HttpStatus.OK.value());
	structure.setMessage("All  Female users found Successfully");
	
	structure.setBody(femaleUser);
		return structure;
	}

	public ResponseStructure<List<User>> findAllAdmins() {
	List<User>	 admins=dao.findAllUser(UserRole.ADMIN);
	
	ResponseStructure<List<User>> structure = new ResponseStructure<>();
	structure.setStatus(HttpStatus.OK.value());
	structure.setMessage("All admins found Successfully");
	structure.setBody(admins);
		return structure;
	}

	
	
	public ResponseStructure<List<User>> findAllInactiveUser() {
		List<User> user = dao.findAlllUser(UserStatus.IN_ACTIVE);
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value()); 
		structure.setMessage("All  InActive users found  Successfully");
		structure.setBody(user);
				return structure;
		
	}

	public ResponseStructure<List<User>> findAllBlockedUsers() {
		
		List<User> user = dao.findAllBlockedUsers(UserStatus.BLOKED);
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value()); 
		structure.setMessage("All  Blocked users found  Successfully");
		structure.setBody(user);
				return structure;
		
	}

	public ResponseStructure<List<User>> findAllDeletedUsers() {
		List<User> user = dao.findAllDeletedUsers(UserStatus.DELLETED);
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value()); 
		structure.setMessage("All  Deleted users found  Successfully");
		structure.setBody(user);
				return structure;
		
	}
	

	public ResponseStructure<User> setStatusToInActive(long id) {
	Optional<User> optional=	dao.findUserById(id);  
	if(optional.isEmpty())
		throw new InValidUserIdException(" that specific id is not present"+id);//optional class is a  wrapper class.
	
 User u  =	optional.get();
 
	u.setStatus(UserStatus.IN_ACTIVE);
  u   =	dao.saveUser(u);
	ResponseStructure<User> structure = new ResponseStructure<>();
structure.setStatus(HttpStatus.OK.value());
structure.setMessage("User status is updated Successfully as in_Active");
structure.setBody(u);
		return structure;
	}
	

	public ResponseStructure<User> setStatusToDeleted(long id) {
			Optional<User> optional=dao.findUserById(id);
			if(optional.isEmpty())
				throw new InValidUserIdException(" that specific id is not present"+id);//optional class is a  wrapper class.
User u=optional.get();
u.setStatus(UserStatus.DELLETED);
			u=dao.saveUser(u);
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("User status is updated Successfully as deleted");
			structure.setBody(u);
					return structure;
			
	}

	public ResponseStructure<User> setStatusToBlocked(long id) {
		Optional<User> optional=dao.findUserById(id);
		if(optional.isEmpty())
			throw new InValidUserIdException(" that specific id is not present"+id);//optional class is a  wrapper class.
User u=optional.get();
u.setStatus(UserStatus.BLOKED);
		u=dao.saveUser(u);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("User status is updated Successfully as Blocked");
		structure.setBody(u);
				return structure;
	}

	public ResponseStructure<User> setStatusToActive(long id) {
	Optional<User> optional=	dao.findUserById(id);
	if(optional.isEmpty())
		throw new InValidUserIdException(" that specific id is not present"+id);//optional class is a  wrapper class.
	User u=optional.get();
	u.setStatus(UserStatus.ACTIVE);
	u=dao.saveUser(u);
	ResponseStructure<User> structure = new ResponseStructure<>();
	structure.setStatus(HttpStatus.OK.value());
	structure.setMessage("User status is updated Successfully as Blocked");
	structure.setBody(u);
			return structure;
	}

	public ResponseStructure<User> setStatusToTerminated(long id) {		
		Optional<User> optional=dao.findUserById(id);
		if(optional.isEmpty())
			throw new InValidUserIdException(" that specific id is not present"+id);//optional class is a  wrapper class.
		User u=optional.get();
		u.setStatus(UserStatus.ACTIVE);
		u=dao.saveUser(u);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("User status is updated Successfully as Blocked");
		structure.setBody(u);
				return structure;
	}    
	//******************************* find users based  on status and  gender *******************************************

	public ResponseStructure<List<User>> findAllActiveMaleUsers() {
	List<User> u=	dao.findByGenderAndStatus(UserGender.MALE,UserStatus.ACTIVE);
		return new ResponseStructure<List<User>>(HttpStatus.OK.value(),"find all male active users",u);
		
	}

	public ResponseStructure<List<MatchingUser>> findAllMatches(Long id, Integer top) {
	Optional<User>	optional=dao.findUserById(id);
	if(optional.isEmpty()) {
		throw new InValidUserIdException("in valid user id unable to find the top matches"+id);
	}
	User user=optional.get();
	UserGender  gender = user.getGender();
//	System.out.println(gender.equals(UserGender.MALE)?UserGender.FEMALE:UserGender.MALE);
	
	List<User> users=new ArrayList<>();
	
	if(gender.equals(UserGender.MALE))
		users=dao.findByGender(gender.FEMALE);
	else
		users=dao.findByGender(gender.MALE);

	//printCollection(users);
	
	List<MatchingUser> matchingUsers= new ArrayList<>();
	for(User u:users) {
		
		MatchingUser mu = new MatchingUser();
		mu.setName(u.getName());
		mu.setAge(u.getAge());
		mu.setIntrest(u.getInterests());;
		mu.setAgeDifference(Math.abs(user.getAge()-u.getAge()));
		mu.setMatchingIntrestCount(countIntrest(user.getInterests(),u.getInterests()));
		mu.setGender(u.getGender());
		matchingUsers.add(mu);
		
	}
	//printCollection(matchingUsers)
	Collections.sort(matchingUsers,new SortByAgeDifferenceAsc());

	//printCollection(matchingUsers)
	matchingUsers=matchingUsers.stream().limit(top).collect(Collectors.toList());
	printCollection(matchingUsers);
	return new ResponseStructure<List<MatchingUser>>(HttpStatus.OK.value(),"All the matching users found Successfully",matchingUsers);

	}
	

	private int countIntrest(List<String> list1, List<String> list2) {
		int c=0;
		for(String s:list1) {
			if(list2.contains(s)) {
				c++;
			}
		}
		return c;
	}

	private void printCollection(Collection c) {
for(Object o:c) {
	System.out.println(o);
}
	}

	
	}

	

