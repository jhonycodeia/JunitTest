package com.bolsaideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsaideas.springboot.app.model.service.IService;

@Controller
public class IndexController {
	
	@Autowired
	//@Qualifier("ServicioSimple")
	private IService service;
	
	
	//@Autowired
	public IndexController(IService service) {
		this.service = service;
	}

	@GetMapping({"","/","/index"})
	public String index(Model model) {
		
		model.addAttribute("operacion", service.operation());
		
		return "index";
	}

	//@Autowired
	public void setService(IService service) {
		this.service = service;
	}
	
	
}
