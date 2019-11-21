package com.example.springboot.spring_dependency_injection.beans;

public class FortuneService implements Fortune {

	@Override
	public String getFortune()
	{
		return "Nice day";
	}

}
