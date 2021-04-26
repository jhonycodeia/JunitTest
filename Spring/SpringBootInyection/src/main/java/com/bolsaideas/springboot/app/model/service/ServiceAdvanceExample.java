package com.bolsaideas.springboot.app.model.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Primary
//@Component("ServicioSimpleAdvance")
//@Service
public class ServiceAdvanceExample implements IService {

	public String operation() {
		return "ejecutando proceso avanzado";
	}
}
