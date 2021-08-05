package com.kgitbank.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

// Departments ���̺� �Ȱ��� ������� ���� ������
public interface EmployeeMapper {
	
	@Select("SELECT * FROM employees")
	public List<Employee> getEmpList();
	
	public List<Employee> getEmpList2();
	
	public Employee getEmployee(int id);
	
	public int create(Employee e);
}
