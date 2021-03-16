package com.example.demo.model;

import java.io.Serializable;

public class Person implements Serializable {

	private Long Id;

	private String name;

	public Person(Long id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
