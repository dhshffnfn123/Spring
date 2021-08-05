package com.kgitbank.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgitbank.model.Member;
import com.kgitbank.service.Join;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/user/*")
@Log4j
public class JoinController {
	
	@Autowired
	ServletContext application;
	@Autowired
	HttpSession session;
	
	
	
	
	@RequestMapping(value = {"/join"}, method = { RequestMethod.POST, RequestMethod.GET})
	public void join() {
		
	}
	
	@PostMapping("/join")
	   public String joinProcess(Member mem) {
	      // System.out.println(mem);
	      
	      if (mem.nullExist()) {
	         log.error("회원 정보에 Null 값이 존재함.");
	         return "redirect:/";
	      }
	      
	      System.out.println(application.getRealPath("/data/user"));
	      
	      File new_member_file = new File(application.getRealPath("/data/user/")
	            + mem.getId() + ".txt");
	      
	      if (new_member_file.exists()) {
	         log.error("이미 가입된 아이디 입니다!");
	         return "redirect:/";
	      }
	      
	      try (
	    		  
	    		  FileOutputStream fout = new FileOutputStream(new_member_file);
	    		  ObjectOutputStream obj_out = new ObjectOutputStream(fout);
	    		
	      ) {
	        obj_out.writeObject(mem);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      return "redirect:/";
	   }
	
//	
//	
//	@PostMapping("/joininfo")
//	public String getjoin(Join join) {
//		log.info("join이 Controller에 도착");
//		log.info(join.toString());
//		
//		return "/user/join";
//	}
	
	
	
	
//	@PostMapping("/success")
//	public void success(Join join, Model model) {
//		log.info("success가 controller에 도착");
//		log.info(join.toString());
//		
//		
//	}
}










