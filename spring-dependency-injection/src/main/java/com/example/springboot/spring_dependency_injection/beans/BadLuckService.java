package com.example.springboot.spring_dependency_injection.beans;

public class BadLuckService implements Fortune
{
	@Override
	public String getFortune() {
		
		return "be aware of your friends";
	}
}
