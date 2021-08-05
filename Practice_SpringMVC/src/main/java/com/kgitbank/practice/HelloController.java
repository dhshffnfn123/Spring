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

   @RequestMapping(value = {"/minsu", "/�μ�"},
         method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
   public String minsu() {
      log.info("minsu controller�� ����");
      
      return "/hello/minsu";
   }
   
   @GetMapping("/chulsu")
   public void getChulsu(
         Human human, 
         @RequestParam("number") int myNumber,
         @RequestParam("taste") ArrayList<String> taste) {
      log.info("chulsu controller�� ����");
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
      // �Ķ���Ϳ� �Ƿ��� ���� �Ű������� ����ְ�, �𵨿��� �ڵ����� �Ƿ��ִ�.
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
      // �տ� redirect:�� ���̸� �並 ã�� �ʰ� �����̷�Ʈ�� �����Ѵ�.
      return "redirect:/hello/park?name=Kim&age=321";
   }
   
   @RequestMapping("/model1")
   public ModelAndView modelAndView() {
      ModelAndView mnv = new ModelAndView();
      
      // addObject�� ��Ʈ����Ʈ�� �ư�
      mnv.addObject("a", 10);
      mnv.addObject("b", "string");
      mnv.addObject("Integer");
      
      // setViewName���� �������� ������ �� ���������� ������ �� �ִ� ���� ��ü! (�߾Ⱦ�)
      mnv.setViewName("/hello/mnv");
      
      return mnv;
   }
   
   @GetMapping("/join")
   public String joinPage(HttpServletRequest request) {
      // �� ���
      // ������Ʈ ���ΰ��
      // ���� ���� ��� <-
      System.out.println(application.getRealPath("./note"));
      
      System.out.println("���� ������ ��� �ϴ� ���: "
            + application.getRealPath("./") + "data\\note\\");
      
      return "/user/join";
   }
   
   @PostMapping("/join")
   public String joinProcess(Member mem) {
      // System.out.println(mem);
      
      if (mem.nullExist()) {
         log.error("ȸ�� ������ Null ���� ������.");
         return "redirect:/";
      }
      
      System.out.println(application.getRealPath("/data/user"));
      
      File new_member_file = new File(application.getRealPath("/data/user/")
            + mem.getId() + ".txt");
      
      if (new_member_file.exists()) {
         log.error("�̹� ���Ե� ���̵� �Դϴ�!");
         return "redirect:/";
      }
      
      try (
            FileOutputStream fout = new FileOutputStream(new_member_file);
            ObjectOutputStream obj_out = new ObjectOutputStream(fout);
      ) {
         obj_out.writeObject(mem);
         log.info("������ ���������� �� ��");
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      return "redirect:/";
   }
   
}