package com.example.springboot.spring_dependency_injection.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TennisCoach implements Coach 
{

	@Autowired
	@Qualifier("randomFortuneService")
	private Fortune fortune;
	
	// define a default constructor
	public TennisCoach() 
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}


	
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune()
	{
		return fortune.getFortune();
	}

}