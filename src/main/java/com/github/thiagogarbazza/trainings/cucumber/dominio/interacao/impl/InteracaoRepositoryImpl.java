package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
class InteracaoRepositoryImpl extends QuerydslRepositorySupport implements InteracaoRepositoryCustom {

  public InteracaoRepositoryImpl() {
    super(Interacao.class);
  }
}
