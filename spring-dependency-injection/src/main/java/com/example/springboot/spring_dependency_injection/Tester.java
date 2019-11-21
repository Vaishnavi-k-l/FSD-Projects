package com.example.springboot.spring_dependency_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springboot.spring_dependency_injection.beans.Coach;

public class Tester 
{

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SportConfig.class);
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

	}

}
