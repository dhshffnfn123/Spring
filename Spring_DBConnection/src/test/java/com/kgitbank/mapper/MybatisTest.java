package com.kgitbank.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgitbank.model.Department;
import com.kgitbank.model.Employee;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	
	@Test
	public void test() {
		
		try(
			SqlSession session = sqlSessionFactory.openSession();
			Connection conn = session.getConnection();
			) {
			log.info(conn);
			assertNotNull(conn);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void getEmpListTest() {
		List<Employee> employees = employeeMapper.getEmpList();
		
		if (employees.size() == 0) {
			fail("¾È²¨³»Áü");
		}
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
	}
	@Ignore
	@Test
	public void getEmpListTest2() {
		List<Employee> employees = employeeMapper.getEmpList();
		
		if (employees.size() == 0) {
			fail("¾È²¨³»Áü");
		}
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
	}
	@Ignore
	@Test
	public void getDepListTest() {
		List<Department> departments = departmentMapper.getDepList();
		
		if (departments.size() == 0) {
			fail("¾È²¨³»Áü");
		}
		
		for (Department department : departments) {
			System.out.println(department);
		}
	}
	
	@Test
	public void getEmployee() {
		Employee employee = employeeMapper.getEmployee(190);
		
		assertNotNull(employee);
		System.out.println(employee);
	}
	
	@Test
	public void createEmployee() {
		Employee e = new Employee("Minsu", "K@Minsu", new Date(), "IT_PROG");
		
		
		
		assertEquals(1, employeeMapper.create(e));
	}
	
//	@Test
//	public void resultMapTest() {
//		HashMap<String, Object> data = employeeMapper.getEmployee(192);
//		
//		System.out.println(data);
//	}
}




















