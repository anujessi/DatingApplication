package com.example.dearapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dearapp.entity.User;
import com.example.dearapp.util.UserGender;
import com.example.dearapp.util.UserRole;
import com.example.dearapp.util.UserStatus;

public interface UserRepository  extends JpaRepository<User, Long>{

	Optional<User> findByPhone(Long phone);

	Optional<User> findByEmail(String email);

	List<User> findByGender(UserGender gender);


	List<User> findByStatus(UserStatus inactive);



	List<User> findByRole(UserRole user);

	List<User> findByGenderAndStatus(UserGender gender, UserStatus status);








}
