package com.kgitbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Person {

	@NonNull
	private String name;
	@NonNull
	private int age;
	@NonNull
	private String address;
	
	 
}
