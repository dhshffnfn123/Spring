package com.kgitbank.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Component
@Data
public class Join {
	String userId;
	String userPass;
	String userName;
	String userBirth;

//	public Join(String id, String pw, String name, Date birth)	{
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.birth = birth;
//	}
	
	
}
