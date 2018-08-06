package com.gustavobastos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavobastos.cursomc.domain.Categoria;
import com.gustavobastos.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias") //endpoint
public class CategoriaResource {
	
	@Autowired
	CategoriaService service;

	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
