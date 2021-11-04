package com.udemy.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursomc.domain.Categoria;
import com.udemy.cursomc.domain.Cidade;
import com.udemy.cursomc.domain.Cliente;
import com.udemy.cursomc.domain.Endereco;
import com.udemy.cursomc.domain.Estado;
import com.udemy.cursomc.domain.ItemPedido;
import com.udemy.cursomc.domain.Pagamento;
import com.udemy.cursomc.domain.PagamentoComBoleto;
import com.udemy.cursomc.domain.PagamentoComCartao;
import com.udemy.cursomc.domain.Pedido;
import com.udemy.cursomc.domain.Produto;
import com.udemy.cursomc.domain.enums.EnumEstadoPagamento;
import com.udemy.cursomc.domain.enums.EnumTipoCliente;
import com.udemy.cursomc.repositories.CategoriaRepository;
import com.udemy.cursomc.repositories.CidadeRepository;
import com.udemy.cursomc.repositories.ClienteRepository;
import com.udemy.cursomc.repositories.EnderecoRepository;
import com.udemy.cursomc.repositories.EstadoRepository;
import com.udemy.cursomc.repositories.ItemPedidoRepository;
import com.udemy.cursomc.repositories.PagamentoRepository;
import com.udemy.cursomc.repositories.PedidoRepository;
import com.udemy.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
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
		
		Cliente cliente1 = new Cliente();
		
		cliente1.setNome("Maria Silva");
		cliente1.setEmail("maria@gmail.com");
		cliente1.setCpfOuCnpj("36378912377");
		cliente1.setTipoCliente(EnumTipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco endereco1 = new Endereco();
		Endereco endereco2 = new Endereco();
		
		endereco1.setLogradouro("Rua Flores");
		endereco1.setNumero("300");
		endereco1.setComplemento("Apto 303");
		endereco1.setBairro("Jardim");
		endereco1.setCep("38220834");
		endereco1.setCliente(cliente1);
		endereco1.setCidade(cidade1);
		
		endereco2.setLogradouro("Avenida Matos");
		endereco2.setNumero("105");
		endereco2.setComplemento("Sala 800");
		endereco2.setBairro("Centro");
		endereco2.setCep("38777012");
		endereco2.setCliente(cliente1);
		endereco2.setCidade(cidade2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
		Pedido pedido1 = new Pedido();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		pedido1.setInstante(simpleDateFormat.parse("30/09/2017 10:32"));
		pedido1.setCliente(cliente1);
		pedido1.setEnderecoEntrega(endereco1);
		
		Pedido pedido2 = new Pedido();
		
		pedido2.setInstante(simpleDateFormat.parse("10/10/2017 19:35"));
		pedido2.setCliente(cliente1);
		pedido2.setEnderecoEntrega(endereco2);
		
		PagamentoComCartao pagamentoComCartao1 = new PagamentoComCartao();
		
		pagamentoComCartao1.setEstadoPagamento(EnumEstadoPagamento.QUITADO);
		pagamentoComCartao1.setPedido(pedido1);
		pagamentoComCartao1.setNumeroParcelas(6);
		
		Pagamento pagamento1 = new PagamentoComCartao();
		pagamento1 = pagamentoComCartao1;
		pedido1.setPagamento(pagamento1);
		
		PagamentoComBoleto pagamentoComBoleto1 = new PagamentoComBoleto();
		
		pagamentoComBoleto1.setEstadoPagamento(EnumEstadoPagamento.PENDENTE);
		pagamentoComBoleto1.setPedido(pedido2);
		pagamentoComBoleto1.setDataVencimento(simpleDateFormat.parse("20/10/2017 00:00"));

		Pagamento pagamento2 = new PagamentoComBoleto();
		pagamento2 = pagamentoComBoleto1;
		pedido2.setPagamento(pagamento2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
		
		ItemPedido itemPedido1 = new ItemPedido();
		itemPedido1.setDesconto(0.00);
		itemPedido1.setQuantidade(1);
		itemPedido1.setPreco(2000.00);
		itemPedido1.getId().setPedido(pedido1);
		itemPedido1.getId().setProduto(produto1);
		
		ItemPedido itemPedido2 = new ItemPedido();
		itemPedido2.setDesconto(0.00);
		itemPedido2.setQuantidade(2);
		itemPedido2.setPreco(80.00);
		itemPedido2.getId().setPedido(pedido1);
		itemPedido2.getId().setProduto(produto3);
		
		ItemPedido itemPedido3 = new ItemPedido();
		itemPedido3.setDesconto(100.00);
		itemPedido3.setQuantidade(1);
		itemPedido3.setPreco(800.00);
		itemPedido3.getId().setPedido(pedido2);
		itemPedido3.getId().setProduto(produto2);
		
		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));
		
		produto1.getItens().addAll(Arrays.asList(itemPedido1));
		produto2.getItens().addAll(Arrays.asList(itemPedido3));
		produto3.getItens().addAll(Arrays.asList(itemPedido2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
	
}
