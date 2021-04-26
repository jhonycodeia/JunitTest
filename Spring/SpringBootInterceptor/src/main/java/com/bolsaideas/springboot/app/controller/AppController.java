package com.bolsaideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@GetMapping({"","/","/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido al chat de Banco rasca");
		
		return "index";
	}
	
	@GetMapping({"/close"})
	public String close(Model model) {
		model.addAttribute("titulo", "Estas accediendo fuera de horario de atencion");
		model.addAttribute("horario", "Inicia a "+apertura+" Termina a las "+cierre);
		
		return "close";
	}

}
