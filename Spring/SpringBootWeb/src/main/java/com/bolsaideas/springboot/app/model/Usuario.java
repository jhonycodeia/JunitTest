package com.bolsaideas.springboot.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private String nombre;
	private String apellido;
	private String email;
}
