package com.udemy.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.domain.Produto;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.repositories.CidadeRepository;
import com.udemy.cursomc.repositories.EstadoRepository;
import com.udemy.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria();
		Categoria categoria2 = new Categoria();
		
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		Produto produto3 = new Produto();
		
		categoria1.setNome("Informática");
		categoria2.setNome("Escritório");
		
		produto1.setNome("Computador");
		produto1.setPreco(2000.00);
		
		produto2.setNome("Impressora");
		produto2.setPreco(500.00);
		
		produto3.setNome("Mouse");
		produto3.setPreco(80.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		
		Estado estado1 = new Estado();
		Estado estado2 = new Estado();
		
		Cidade cidade1 = new Cidade();
		Cidade cidade2 = new Cidade();
		Cidade cidade3 = new Cidade();
		
		estado1.setNome("Minas Gerais");
		estado2.setNome("São Paulo");
		
		cidade1.setNome("Uberlândia");
		cidade1.setEstado(estado1);
		
		cidade2.setNome("São Paulo");
		cidade2.setEstado(estado2);
		
		cidade3.setNome("Campinas");
		cidade3.setEstado(estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
	}

}
