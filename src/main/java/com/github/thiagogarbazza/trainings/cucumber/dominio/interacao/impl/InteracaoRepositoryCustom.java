package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;

import java.util.Collection;

interface InteracaoRepositoryCustom {

  Collection<Interacao> pesquisar(InteracaoFiltro filtro);
}
