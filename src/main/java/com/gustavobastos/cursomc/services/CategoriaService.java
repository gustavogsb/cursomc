package com.gustavobastos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavobastos.cursomc.domain.Categoria;
import com.gustavobastos.cursomc.repositories.CategoriaRepository;
import com.gustavobastos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

		@Autowired
		private CategoriaRepository repo;
		
		/* Versão anterior ao JPA 2.X.X e anterior ao JAVA 1.8
		public Categoria buscar(Integer id) {
			Categoria obj = repo.findOne(id);
			return obj;
		}
		*/
		
		public Categoria buscar(Integer id) { 
			Optional<Categoria> obj = repo.findById(id);  
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Categoria.class.getName())); 
		}	
}
