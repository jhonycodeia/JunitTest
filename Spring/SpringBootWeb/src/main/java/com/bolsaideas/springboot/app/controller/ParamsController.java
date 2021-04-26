package com.bolsaideas.springboot.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	
	@GetMapping("/")
	public String index(@RequestParam(name = "texto",required = false) String texto,Model model) {
		model.addAttribute("resultado", "el texto enviado es "+texto);
				
		return "params/index";
	}
	
	@GetMapping("/string")
	public String params(@RequestParam(name = "texto",required = false) String texto,Model model) {
		model.addAttribute("resultado", "el texto enviado es "+texto);
				
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String params(@RequestParam String texto,@RequestParam Integer numero,Model model) {
		model.addAttribute("resultado", "el texto enviado es "+texto + " el numero es "+numero);
				
		return "params/ver";
	}
	
	@GetMapping("/mix-params2")
	public String params(HttpServletRequest request,Model model) {
		String texto = request.getParameter("texto");
		Integer numero;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "el texto enviado es "+texto + " el numero es "+numero);
				
		return "params/ver";
	}
	
	@GetMapping("/string2")
	public String params2(@RequestParam(name = "texto",defaultValue = "no hay") String texto,Model model) {
		model.addAttribute("resultado", "el texto enviado es ".concat(texto));
				
		return "params/ver";
	}
	

}
