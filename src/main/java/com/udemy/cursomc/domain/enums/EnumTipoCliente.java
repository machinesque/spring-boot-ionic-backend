package com.udemy.cursomc.domain.enums;

import java.util.Iterator;

public enum EnumTipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private int codigo;
	private String descricao;

	private EnumTipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoCliente toEnum(Integer codigo) {

		if (codigo != null) {
			for (EnumTipoCliente tipoCliente : EnumTipoCliente.values()) {

				if (codigo.equals(tipoCliente.getCodigo())) {
					return tipoCliente;
				}

			}
			
			throw new IllegalArgumentException("Id inválido: " + codigo);
		}
		
		return null;

	}

}
