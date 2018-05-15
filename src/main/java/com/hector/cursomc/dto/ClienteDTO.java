package com.hector.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.hector.cursomc.domain.Cliente;


public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 y 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Email(message ="Email Invalido")
	private String email;
	
	// Constructor Vacio
	public ClienteDTO() {		
	}
	
	// Crear un constructor que recibe una entidade cliente y genera mi Dto
	public ClienteDTO(Cliente obj) {
		id 		= obj.getId();
		nome 	= obj.getNome();
		email 	= obj.getEmail();
	}

	// Crear los Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
