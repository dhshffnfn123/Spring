package com.kgitbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Person;

public interface PersonMapper {

	public List<Person> select();
	public int insert(Person person);
	public int delete(String name);
	
}
