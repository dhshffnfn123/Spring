package com.kgitbank.mapper;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.fail;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.kgitbank.model.Person;
//
//import lombok.extern.log4j.Log4j;
//
//@Log4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//public class PersonTest {
//	
////	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
////	@Autowired
//	private PersonMapper personMapper;

//	@Test
//	public void test() {
		
//		try(
//			SqlSession session = sqlSessionFactory.openSession();
//			Connection conn = session.getConnection();
//			) {
//			
////			List<Person> people = personMapper.select();
//			
//			if(people.size() == 0) {
//				fail("¾È²¨³»Áü");
//			}
//			
//			for(Person person : people) {
//				System.out.println(person);
//			}
//			
//			
//			log.info(conn);
//			assertNotNull(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//}
