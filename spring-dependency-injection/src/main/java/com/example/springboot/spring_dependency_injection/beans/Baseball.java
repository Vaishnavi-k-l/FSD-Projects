package com.example.springboot.spring_dependency_injection.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

//@Setter

public class Baseball implements Coach {

	//private Fortune fortune;
	
	//This is for annotations
	@Autowired
	private FortuneService fortune;
	
	@Override
	public String getDailyWorkout() 
	{
			return "Run 2k";
	}
	
	public String getDailyFortune()
	{
		return fortune.getFortune().toString();
				
	}

}
