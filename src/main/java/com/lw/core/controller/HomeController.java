package com.lw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	
	@RequestMapping("/home")
	public String home(Model m){
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model m){
		return "welcome";
	}
}