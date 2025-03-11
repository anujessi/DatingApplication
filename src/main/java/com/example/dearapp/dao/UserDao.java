package com.example.dearapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dearapp.entity.User;
import com.example.dearapp.repository.UserRepository;
import com.example.dearapp.util.UserGender;
import com.example.dearapp.util.UserRole;
import com.example.dearapp.util.UserStatus;

@Repository
public class UserDao {
	@Autowired
	
	private UserRepository repo;

	public User saveUser(User u) {
		return repo.save(u);
	}

	public Optional<User> findByPhone(Long phone) {
		return repo.findByPhone(phone);
	}

	public Optional<User> findByEmail(String email) {
		return repo.findByEmail(email);
	}

	public List<User> findAllUsers() {
		return repo.findAll();
	}

	public Optional<User> findUserById(Long id) {
		return repo.findById(id);
	}

	public List<User> findAllMaleUsers(UserGender gender) {
		return  repo.findByGender(gender);
	}

	public List<User> findAllFemaleUsers(UserGender gender) {
		return repo.findByGender(gender);
	}

	

	public List<User> findAllUser(UserRole user) {
		
		return  repo.findByRole(user);
	}

	public List<User> findAlllUser(UserStatus inActive) {
		return repo.findByStatus(inActive);
	}

	public List<User> findAllBlockedUsers(UserStatus bloked) {
		return repo.findByStatus(bloked);
	}

	public List<User> findAllDeletedUsers(UserStatus deleted) {
		return repo.findByStatus(deleted);
	}

	public List<User> findByGenderAndStatus(UserGender male, UserStatus active) {
		// TODO Auto-generated method stub
		return repo.findByGenderAndStatus(male, active);
	}

	public List<User> findByGender(UserGender gender) {
		return repo.findByGender(gender);
	}


}
