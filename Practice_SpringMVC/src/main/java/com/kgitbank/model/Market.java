package com.kgitbank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Market {
	
	private Fruit fruit;
	
	@Autowired
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public Fruit getFruit() {
		return fruit;
	}
}
