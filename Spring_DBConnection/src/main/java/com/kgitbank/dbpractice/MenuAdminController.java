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

	   // 원래 새로운 메뉴를 추가할 때 해야할 작업들을 처리해야 한다 (비즈니스 로직에서 해야한다)
	   // ex) 동일한 이름의 메뉴가 있는지 체크, 메뉴 이름이 형식에 맞는지 체크, 값은 제대로 왔는지 체크
	   
//	   System.out.println("동일한 메뉴가 이쓴ㄴ지 체크하는 코드입니다. 50줄");
//	   System.out.println("메뉴이름 형식 체크. 150줄");
//	   System.out.println("Null 값 체크. 30줄");
//	   
//	   menu_mapper.newMenu(m);
	   menu_service.addMenu(m);
      
      // 컨트롤러에서는 데이터를 어트리뷰트에 싣고 다음 페이지로 안내하는 작업만 하는 것이 바람직하다
      
      return "redirect:/menu/";
   }
   
}