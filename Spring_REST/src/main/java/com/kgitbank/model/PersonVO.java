package com.kgitbank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PersonVO {
	String name;
	int age;
	String address;
	
	public PersonVO() {
		name = "김수한무";
		age = 50;
		address = "서울";
	}
}
