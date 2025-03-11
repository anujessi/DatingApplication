package com.example.dearapp.responsestructure;

import java.util.List;

import com.example.dearapp.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T> {
	private Integer status;
	private String Message;
	private T body;

}
