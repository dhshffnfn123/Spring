package com.kgitbank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FruitVO {
	String name;
	int price;
	int calorie;
	
	public FruitVO() {
		name = "»ç°ú";
		price = 1500;
		calorie = 300;
	}
}
