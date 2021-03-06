package br.com.cadmea.comuns.orm.enums;

import br.com.cadmea.comuns.orm.DomainElement;

public enum Gender implements DomainElement {

  MASCULINO("Masculino"), FEMININO("Feminino");

  private Gender(String d) {
    descricao = d;
  }

  private String descricao;

  @Override
  public String getDescription() {
    return descricao;
  }

}
