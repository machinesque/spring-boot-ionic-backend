package com.udemy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.repositories.ClienteRepository;
import com.udemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPorId(Long id) {
	
		Optional<Cliente> objetoCliente = clienteRepository.findById(id);
		return objetoCliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrada! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	}
	
}
