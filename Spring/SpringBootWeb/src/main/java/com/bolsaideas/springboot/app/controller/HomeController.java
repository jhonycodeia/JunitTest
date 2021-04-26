package com.bolsaideas.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(){
		return "redirect:/app/index";
	}
	
	@GetMapping("/google")
	public String google(){
		return "redirect:https://www.google.com";
	}
	//Esta forma no se pierden los parametro no sobrecarga la pagina
	@GetMapping("/forward")
	public String forward(){
		return "forward:/app/index";
	}
}
