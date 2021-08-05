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
		System.out.println("������ �޴��� �̾����� üũ�ϴ� �ڵ��Դϴ�. 50��");
		System.out.println("�޴��̸� ���� üũ. 150��");
		System.out.println("Null �� üũ. 30��");
		
		Log.info(menu_mapper);
		
		return true;
	   
	   return menu_mapper.newMenu(m) > 0;
	}
	
}
