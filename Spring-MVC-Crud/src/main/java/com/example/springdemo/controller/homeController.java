package com.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.model.Student;

@Controller
public class homeController
{
	@RequestMapping("/")
	public String homeMethod()
	{
		return "main-menu";
	}
	
/*	@RequestMapping("/studentForm")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("student", new Student());
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student,Model theModel)
	{
		theModel.addAttribute("student", student);
		return "process-form";
	}*/
}
