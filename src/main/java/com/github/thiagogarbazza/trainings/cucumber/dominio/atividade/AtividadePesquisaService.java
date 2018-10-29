package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;

import java.util.Collection;

public interface AtividadePesquisaService {
  Collection<Atividade> pesquisar(Interacao interacao);
}
