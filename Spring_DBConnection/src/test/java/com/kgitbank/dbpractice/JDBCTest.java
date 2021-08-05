package com.kgitbank.dbpractice;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JDBCTest {

   @Autowired
   HikariDataSource datasource;
   
   @Before
   public void testConfig() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      System.out.println("@Before°¡ ÁøÇàµÊ");
   }
   
   @Test
   public void testGetConnection() {
      String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
      String user = "java1";
      String password = "1234";
      
      try (
         Connection conn = DriverManager.getConnection(url, user, password);
      ) {
         log.info(conn);
         assertNotNull(conn);
      } catch(SQLException e) {
         fail(e.getMessage());
      }
   }
   @Test
   public void testHikariDataSource() {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
      config.setUsername("java1");
      config.setPassword("1234");
      config.addDataSourceProperty("cachePrepStmts", "true");
      config.addDataSourceProperty("prepStmtCacheSize", "250");
      config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

      HikariDataSource ds = new HikariDataSource(config);
      
      
      try (
         Connection conn = ds.getConnection();
      ) {
         log.info(conn);
         assertNotNull(conn);
      } catch (SQLException e) {
         fail(e.getMessage());
      }
   }
   
   @Test
   public void contextDataSourceTest() {
      try(
         Connection conn = datasource.getConnection()
      ){
         log.info(conn);
         assertNotNull(conn);
      } catch (SQLException e) {
         fail(e.getMessage());
      }
   }
   
}
