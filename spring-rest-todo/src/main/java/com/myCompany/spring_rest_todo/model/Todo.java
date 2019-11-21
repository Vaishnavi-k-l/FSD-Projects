package com.myCompany.spring_rest_todo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo 
{
	private int id;
	private String user;
	private String description;
	private Date targetdate;
	private boolean isDone;
}
