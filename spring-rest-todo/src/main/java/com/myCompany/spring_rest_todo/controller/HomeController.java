package com.myCompany.spring_rest_todo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.myCompany.spring_rest_todo.model.User;
import com.myCompany.spring_rest_todo.service.LoginService;

@Controller
public class HomeController 
{
	@Autowired
	private LoginService loginservice;
	private User theUser = new User();
	
	@RequestMapping(value="/")
	public String test()
	{
		return "home";
	}
	
	
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public String login(Model model)
	{
		User theUser = new User();
		 model.addAttribute("user", theUser);
		return "login";
	}
	
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * displayLogin(Model model) { model.addAttribute("user", new User()); return
	 * "login"; }
	 */
	
	@RequestMapping(value = "/processlogin" , method = RequestMethod.POST)
	public String afterlogin(@ModelAttribute("user") User theUser)
	{
		boolean val = loginservice.ValidateUser(theUser);
		System.out.println(val);
		if(val == true)
			return "welcome";
		else
			return "login";
	}
}
