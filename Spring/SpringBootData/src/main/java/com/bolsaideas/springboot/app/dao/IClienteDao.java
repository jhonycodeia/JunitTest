package com.bolsaideas.springboot.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsaideas.springboot.app.model.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
}
