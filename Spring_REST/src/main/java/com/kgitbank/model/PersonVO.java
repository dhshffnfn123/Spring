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
		name = "����ѹ�";
		age = 50;
		address = "����";
	}
}
