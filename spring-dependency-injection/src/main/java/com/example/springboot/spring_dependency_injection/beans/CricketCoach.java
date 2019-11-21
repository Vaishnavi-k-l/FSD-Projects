package com.example.springboot.spring_dependency_injection.beans;

import lombok.Setter;

@Setter
public class CricketCoach implements Coach {

	
	private String email;
	private String teamname;
	private Fortune fortune;
	
	@Override
	public String getDailyWorkout() 
	{
		
		return "run 2k";
	}

	@Override
	public String getDailyFortune() 
	{
		
		return fortune.getFortune().toString();
	}

	@Override
	public String toString() {
		return "CricketCoach [email=" + email + ", teamname=" + teamname + "]";
	}

}
