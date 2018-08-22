package com.gustavobastos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavobastos.cursomc.domain.Cliente;
import com.gustavobastos.cursomc.repositories.ClienteRepository;
import com.gustavobastos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

		@Autowired
		private ClienteRepository repo;
		
		/* Versão anterior ao JPA 2.X.X e anterior ao JAVA 1.8
		public Cliente buscar(Integer id) {
			Cliente obj = repo.findOne(id);
			return obj;
		}
		*/
		
		public Cliente buscar(Integer id) { 
			Optional<Cliente> obj = repo.findById(id);  
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Cliente.class.getName())); 
		}	
}
