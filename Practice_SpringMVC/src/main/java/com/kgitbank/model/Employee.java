package com.kgitbank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Employee {
   @NonNull
   private int employee_id;
   private String first_name;
   @NonNull
   private String last_name;
   @NonNull
   private String email;
   private int department_id;

}