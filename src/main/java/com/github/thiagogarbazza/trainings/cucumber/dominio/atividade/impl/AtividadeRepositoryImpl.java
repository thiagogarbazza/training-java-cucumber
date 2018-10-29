package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.QAtividade.atividade;

@Repository
class AtividadeRepositoryImpl extends QuerydslRepositorySupport implements AtividadeRepositoryCustom {

  public AtividadeRepositoryImpl() {
    super(Atividade.class);
  }

  @Override
  public Collection<Atividade> pesquisar(final Interacao interacao) {
    return from(atividade)
        .where(atividade.interacao.eq(interacao))
        .fetch();
  }
}
