package com.bolsaideas.springboot.app.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemFactura {
	
	private Producto producto;
	private Integer cantidad;

	public Integer importe() {
		return cantidad*producto.getPrecio();
	}
}
