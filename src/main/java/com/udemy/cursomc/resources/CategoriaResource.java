package com.udemy.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
//	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria categoria1 = new Categoria();
		Categoria categoria2 = new Categoria();
		
		categoria1.setId(1L);
		categoria1.setNome("Informática");
		
		categoria2.setId(2L);
		categoria2.setNome("Escritório");
		
		List<Categoria> listaCategorias = new ArrayList<>();

		listaCategorias.add(categoria1);
		listaCategorias.add(categoria2);
		
		return listaCategorias;
	}
	
}
