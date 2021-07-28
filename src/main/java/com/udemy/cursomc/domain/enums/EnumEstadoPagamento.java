package com.udemy.cursomc.domain.enums;

import java.util.Iterator;

public enum EnumEstadoPagamento {

	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private int codigo;
	private String descricao;

	private EnumEstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumEstadoPagamento toEnum(Integer codigo) {

		if (codigo != null) {
			for (EnumEstadoPagamento estadoPagamento : EnumEstadoPagamento.values()) {

				if (codigo.equals(estadoPagamento.getCodigo())) {
					return estadoPagamento;
				}

			}
			
			throw new IllegalArgumentException("Id inválido: " + codigo);
		}
		
		return null;

	}

}
