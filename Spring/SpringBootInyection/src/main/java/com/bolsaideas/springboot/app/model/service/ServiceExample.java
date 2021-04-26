package com.bolsaideas.springboot.app.model.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("ServicioSimple")
//@Service
public class ServiceExample implements IService {

	public String operation() {
		return "ejecutando proceso basico";
	}
}
