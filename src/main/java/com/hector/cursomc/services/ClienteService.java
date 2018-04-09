package com.hector.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hector.cursomc.domain.Cliente;
import com.hector.cursomc.repositories.ClienteRepository;
import com.hector.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {		
		Cliente obj = repo.findOne(id);		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto no encontrado! Id: " + id
					+ ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
}
