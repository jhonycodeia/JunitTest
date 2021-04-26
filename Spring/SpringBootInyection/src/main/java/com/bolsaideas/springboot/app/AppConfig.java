package com.bolsaideas.springboot.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsaideas.springboot.app.model.domain.ItemFactura;
import com.bolsaideas.springboot.app.model.domain.Producto;
import com.bolsaideas.springboot.app.model.service.IService;
import com.bolsaideas.springboot.app.model.service.ServiceAdvanceExample;
import com.bolsaideas.springboot.app.model.service.ServiceExample;

@Configuration
public class AppConfig {
	
	@Bean("ServicioBase")
	public IService service() {
		return new ServiceExample();
	}
	
	@Bean("ServicioAdvance")
	@Primary
	public IService serviceAdv() {
		return new ServiceAdvanceExample();
	}
	
	@Bean("itemFactura")
	public List<ItemFactura> listaItems(){
		return Arrays.asList(new ItemFactura(new Producto("Camara",1200),2),new ItemFactura(new Producto("Smartphone",3000), 1));
	}

}
