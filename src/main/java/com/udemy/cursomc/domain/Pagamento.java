package com.udemy.cursomc.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.udemy.cursomc.domain.enums.EnumEstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  //Mapeamento de Herança
public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private Integer estadoPagamento;
	
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId   //Com essa anotação garantimos que o ID do pagamento será o mesmo para o Pedido
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumEstadoPagamento getEstadoPagamento() {
		return EnumEstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EnumEstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCodigo();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
