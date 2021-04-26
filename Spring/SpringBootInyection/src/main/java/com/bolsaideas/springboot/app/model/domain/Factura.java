package com.bolsaideas.springboot.app.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Scope("prototype") varias instancia por sesion
@ApplicationScope //singleto del contexto servelt
//@SessionScope //instancia es objeto de sesion autenticacion,carrito debe implementar serializable no funcion @predestroy
//@RequestScope //Duracion de una peticion http
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9123854783014499736L;
	@Value("${factura.descripcion}")
	private String descripcion;
	@Autowired
	private Cliente cliente;
	@Autowired
	private List<ItemFactura> items;
	
	@PostConstruct
	public void init() {
		cliente.setNombre("shyla");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("factura destruida");
	}

}
