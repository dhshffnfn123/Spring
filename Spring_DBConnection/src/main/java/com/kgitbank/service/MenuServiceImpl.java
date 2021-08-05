package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuMapper menu_mapper;
	
	public boolean addNewMenu(Menu m) {
		System.out.println("동일한 메뉴가 이쓴ㄴ지 체크하는 코드입니다. 50줄");
		System.out.println("메뉴이름 형식 체크. 150줄");
		System.out.println("Null 값 체크. 30줄");
		
		Log.info(menu_mapper);
		
		return true;
	   
	   return menu_mapper.newMenu(m) > 0;
	}
	
}
