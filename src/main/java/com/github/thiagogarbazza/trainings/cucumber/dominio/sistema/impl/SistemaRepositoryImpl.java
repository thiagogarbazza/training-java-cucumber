package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.QSistema.sistema;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Repository
class SistemaRepositoryImpl extends QuerydslRepositorySupport implements SistemaRepositoryCustom {

  public SistemaRepositoryImpl() {
    super(Sistema.class);
  }

  @Override
  public Collection<Sistema> pesquisar(final SistemaFiltroPesquisa filtro) {
    JPQLQuery query = from(sistema);

    if (isNotBlank(filtro.getTexto())) {
      BooleanExpression texto = sistema.nome.containsIgnoreCase(filtro.getTexto())
          .or(sistema.sigla.containsIgnoreCase(filtro.getTexto()));
      query.where(texto);
    }

    return query.fetch();
  }
}
