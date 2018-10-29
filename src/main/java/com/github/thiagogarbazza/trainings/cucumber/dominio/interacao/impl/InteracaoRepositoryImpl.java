package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.QInteracao.interacao;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Repository
class InteracaoRepositoryImpl extends QuerydslRepositorySupport implements InteracaoRepositoryCustom {

  public InteracaoRepositoryImpl() {
    super(Interacao.class);
  }

  @Override
  public Collection<Interacao> pesquisar(final InteracaoFiltro filtro) {
    JPQLQuery query = from(interacao);

    if (isNotBlank(filtro.getNome())) {
      query.where(interacao.nome.likeIgnoreCase("%"+filtro.getNome()+"%"));
    }

    if (filtro.getSistema() != null) {
      query.where(interacao.sistema.pk.eq(filtro.getSistema()));
    }

    return query.fetch();
  }
}
