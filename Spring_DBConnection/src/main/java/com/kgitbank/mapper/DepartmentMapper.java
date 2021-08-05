package com.kgitbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Department;


public interface DepartmentMapper {
	
	@Select("SELECT * FROM departments")
	public List<Department> getDepList();
}
