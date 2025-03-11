package com.example.dearapp.entity;

import java.util.List;

import com.example.dearapp.util.UserGender;
import com.example.dearapp.util.UserRole;
import com.example.dearapp.util.UserStatus;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private Integer age;
	private String email;
	private Long phone;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserGender gender=UserGender.MALE;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status=UserStatus.IN_ACTIVE;
	
	@Enumerated(EnumType.STRING)
	private UserRole role=UserRole.USER;
	
	@ElementCollection
	private List<String> interests;
	
 //end points                               //requested data                                           responses                comments
 
//	 -save--  /api/v1/users                 	// json object with the  fields data.                 {}                           id should not taken from the user.


//get-users	                                           {}
	
	// get    /users/status/active
	//   /users/status/{status}
}
