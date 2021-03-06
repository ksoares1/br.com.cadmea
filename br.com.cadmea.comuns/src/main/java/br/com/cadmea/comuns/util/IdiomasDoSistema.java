package br.com.cadmea.comuns.util;

import br.com.cadmea.comuns.orm.DomainElement;

public enum IdiomasDoSistema implements DomainElement {

	PORTUGUES_BRASILEIRO("pt_BR"), INGLES_AMERICANO("en_US");

	private String descricao;

	IdiomasDoSistema(String _descricao) {
		this.descricao = _descricao;
	}

	@Override
	public String getDescription() {
		return descricao;
	}

}
