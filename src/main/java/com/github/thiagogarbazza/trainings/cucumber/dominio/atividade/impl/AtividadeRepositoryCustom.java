package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;

import java.util.Collection;

interface AtividadeRepositoryCustom {

  Collection<Atividade> pesquisar(Interacao interacao);
}
