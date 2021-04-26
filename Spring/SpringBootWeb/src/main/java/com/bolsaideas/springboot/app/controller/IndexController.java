package com.bolsaideas.springboot.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bolsaideas.springboot.app.model.Usuario;

@Controller //controla las peticiones del usuario
@RequestMapping("/app")
public class IndexController {
	
	@Value("${text.index}")
	private String textIndex;
	
	@Value("${text.perfil}")
	private String textPerfil;
	
	@Value("${text.listar}")
	private String textListar;

	@GetMapping(value = "/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario("jhony","sarria",null);
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(new Usuario("jhony","sarria","jhony@gmail.com"));
		usuarios.add(new Usuario("andre","serna","anfre@gmail.com"));
		usuarios.add(new Usuario("shyla","stylez","shyla@gmail.com"));
		usuarios.add(new Usuario("scarlet","hanzon","scarlte@gmail.com"));
		
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("titulo", textListar +" vairable");
		
		return "listar";
	}
	
	@GetMapping(value = "/listar2")
	public String listar2(Model model) {
		model.addAttribute("titulo", "listar de usuario : ");
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> llenarLista(){
		return Arrays.asList(new Usuario("jhony","sarria","jhony@gmail.com"),
							new Usuario("andre","serna","anfre@gmail.com"),
							new Usuario("scarlet","hanzon","scarlte@gmail.com"));
	}
	
	
	//@PostMapping(value = "/index")
	@RequestMapping(value = {"/index","/","/home"},method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("titulo",textIndex);
		
		return "index";
	}
	
	@RequestMapping(value = {"/Example1"},method = RequestMethod.GET)
	public String indexExample1(ModelMap model) {
		
		model.addAttribute("titulo", "hola spring Example1");
		
		return "index";
	}
	
	@RequestMapping(value = {"/Example2"},method = RequestMethod.GET)
	public String indexExample2(Map<String,String> model) {
		
		model.put("titulo", "hola spring Example2");
		
		return "index";
	}
	
	@RequestMapping(value = {"/Example3"},method = RequestMethod.GET)
	public ModelAndView indexExample3(ModelAndView model) {
		
		model.addObject("titulo", "hola spring Example3");
		model.setViewName("index");
		
		return model;
	}
}
