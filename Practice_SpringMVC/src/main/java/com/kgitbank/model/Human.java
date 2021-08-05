package com.kgitbank.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Human {
	String name;
	int age;
}
