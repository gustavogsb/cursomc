package com.gustavobastos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavobastos.cursomc.domain.Pedido;
import com.gustavobastos.cursomc.repositories.PedidoRepository;
import com.gustavobastos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

		@Autowired
		private PedidoRepository repo;
		
		/* Versão anterior ao JPA 2.X.X e anterior ao JAVA 1.8
		public Pedido buscar(Integer id) {
			Pedido obj = repo.findOne(id);
			return obj;
		}
		*/
		
		public Pedido buscar(Integer id) { 
			Optional<Pedido> obj = repo.findById(id);  
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Pedido.class.getName())); 
		}	
}
