package com.udemy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Pedido;
import com.udemy.cursomc.repositories.PedidoRepository;
import com.udemy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscarPorId(Long id) {
	
		Optional<Pedido> objetoPedido = pedidoRepository.findById(id);
		return objetoPedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrada! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}
	
}
