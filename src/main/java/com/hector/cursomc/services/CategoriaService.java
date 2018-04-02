package com.hector.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hector.cursomc.domain.Categoria;
import com.hector.cursomc.repositories.CategoriaRepository;
import com.hector.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {		
		Categoria obj = repo.findOne(id);		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto no encontrado! Id: " + id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
}
