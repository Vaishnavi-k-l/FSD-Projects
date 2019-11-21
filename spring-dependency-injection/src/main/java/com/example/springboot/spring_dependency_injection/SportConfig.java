package com.example.springboot.spring_dependency_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.spring_dependency_injection.beans.Coach;
import com.example.springboot.spring_dependency_injection.beans.Fortune;
import com.example.springboot.spring_dependency_injection.beans.HappyFortuneService;
import com.example.springboot.spring_dependency_injection.beans.RandomFortuneService;
import com.example.springboot.spring_dependency_injection.beans.SadFortuneService;
import com.example.springboot.spring_dependency_injection.beans.TennisCoach;

@Configuration
@ComponentScan(basePackages = "com.example")

public class SportConfig 
{
	@Bean
	public Coach tennisCoach()
	{
		return new TennisCoach (randomFortuneService());
		//return new TennisCoach ();
	}
	
	
	  @Bean 
	  public Fortune sadFortuneService() 
	  {
		  return new SadFortuneService(); 
	  }
	  
	  @Bean 
	  public Fortune randomFortuneService() 
	  {
		  return new RandomFortuneService();
	}
	 
	/*
	 * @Bean public Fortune happyFortuneService() { return new
	 * HappyFortuneService(); }
	 */
	 
}