package com.kgitbank.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Department {
	
	@NonNull
	private int department_id;
	@NonNull
	private String department_name;
	private int manager_id;
	private int location_Id;

}
