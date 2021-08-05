package com.kgitbank.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgitbank.model.Human;
import com.kgitbank.model.Member;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/hello")
public class HelloController {
   
   @Autowired
   ServletContext application;

   @RequestMapping(value = {"/minsu", "/민수"},
         method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
   public String minsu() {
      log.info("minsu controller에 도착");
      
      return "/hello/minsu";
   }
   
   @GetMapping("/chulsu")
   public void getChulsu(
         Human human, 
         @RequestParam("number") int myNumber,
         @RequestParam("taste") ArrayList<String> taste) {
      log.info("chulsu controller에 도착");
      log.info("name: " + human.getName());
      log.info("age: " + human.getAge());
      log.info("myNumber: " + myNumber);
      log.info(taste);
   }
   
   @PostMapping("/chulsu")
   public void postChulsu() {
      log.info("post chulsu");
   }
   
   @GetMapping("/choosinsu")
   public String choo(Model model, 
         @ModelAttribute("age") int age, @ModelAttribute("name") String name) {
      // 파라미터에 실려온 값이 매개변수에 들어있고, 모델에도 자동으로 실려있다.
      System.out.println("age: " + age);
      System.out.println("name: " + name);
      
      model.addAttribute("attr1", "ABC"); 
      model.addAttribute("ABCDEFG"); // ${string}
      
      return "/hello/choosinsu";
   }
   
   @GetMapping("/park")
   public void park(Human human) {}
   
   @GetMapping("/kim")
   public String kim() {
      // 앞에 redirect:을 붙이면 뷰를 찾지 않고 리다이렉트를 응답한다.
      return "redirect:/hello/park?name=Kim&age=321";
   }
   
   @RequestMapping("/model1")
   public ModelAndView modelAndView() {
      ModelAndView mnv = new ModelAndView();
      
      // addObject로 어트리뷰트도 싣고
      mnv.addObject("a", 10);
      mnv.addObject("b", "string");
      mnv.addObject("Integer");
      
      // setViewName으로 다음으로 포워드 할 페이지까지 선택할 수 있는 만능 객체! (잘안씀)
      mnv.setViewName("/hello/mnv");
      
      return mnv;
   }
   
   @GetMapping("/join")
   public String joinPage(HttpServletRequest request) {
      // 웹 경로
      // 프로젝트 내부경로
      // 실제 파일 경로 <-
      System.out.println(application.getRealPath("./note"));
      
      System.out.println("내가 파일을 써야 하는 경로: "
            + application.getRealPath("./") + "data\\note\\");
      
      return "/user/join";
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
         log.info("파일을 성공적으로 다 씀");
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      return "redirect:/";
   }
   
}