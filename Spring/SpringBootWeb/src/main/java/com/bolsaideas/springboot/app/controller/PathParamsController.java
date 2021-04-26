package com.bolsaideas.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/path")
public class PathParamsController {

	@GetMapping("/")
	public String index(@RequestParam(name = "texto",required = false) String texto,Model model) {
		model.addAttribute("resultado", "el texto enviado es "+texto);
				
		return "path/index";
	}
	
	@GetMapping("/string/{texto}")
	public String path(@PathVariable(name = "texto") String texto,Model model) {
		model.addAttribute("resultado", "el texto enviado es "+texto);
				
		return "path/ver";
	}
	
	@GetMapping("/string2/{texto}/{numero}")
	public String path(@PathVariable(name = "texto") String texto,@PathVariable(name = "numero") Integer numero,Model model) {
		model.addAttribute("resultado", "el texto enviado es "+texto+" numero es "+numero);
				
		return "path/ver";
	}
	
}
