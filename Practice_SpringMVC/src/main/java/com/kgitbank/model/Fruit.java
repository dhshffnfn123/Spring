package com.kgitbank.model;

import org.springframework.stereotype.Component;

@Component
public class Fruit {

	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
