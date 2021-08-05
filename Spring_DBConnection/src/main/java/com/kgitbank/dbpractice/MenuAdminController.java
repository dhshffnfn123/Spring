package com.kgitbank.dbpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kgitbank.mapper.MenuMapper;
import com.kgitbank.model.Menu;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MenuAdminController {

   @Autowired
   MenuService menu_service;
   
   @GetMapping("/menu/")
   public String main() {
      return "CRUD";
   }
   
   @GetMapping("/menu/add")
   public void addView() {
   }
   
   @PostMapping("/menu/add")
   public String addService(Menu m) {

	   // ���� ���ο� �޴��� �߰��� �� �ؾ��� �۾����� ó���ؾ� �Ѵ� (����Ͻ� �������� �ؾ��Ѵ�)
	   // ex) ������ �̸��� �޴��� �ִ��� üũ, �޴� �̸��� ���Ŀ� �´��� üũ, ���� ����� �Դ��� üũ
	   
//	   System.out.println("������ �޴��� �̾����� üũ�ϴ� �ڵ��Դϴ�. 50��");
//	   System.out.println("�޴��̸� ���� üũ. 150��");
//	   System.out.println("Null �� üũ. 30��");
//	   
//	   menu_mapper.newMenu(m);
	   menu_service.addMenu(m);
      
      // ��Ʈ�ѷ������� �����͸� ��Ʈ����Ʈ�� �ư� ���� �������� �ȳ��ϴ� �۾��� �ϴ� ���� �ٶ����ϴ�
      
      return "redirect:/menu/";
   }
   
}