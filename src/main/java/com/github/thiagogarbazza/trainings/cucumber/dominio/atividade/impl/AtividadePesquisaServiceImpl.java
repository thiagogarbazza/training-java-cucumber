package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.AtividadePesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.QAtividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.QAtividade.atividade;

@Service
class AtividadePesquisaServiceImpl implements AtividadePesquisaService {

  @Autowired
  private AtividadeRepository repository;

  @Override
  public Collection<Atividade> pesquisar(final Interacao interacao) {
    return repository.pesquisar(interacao);
  }
}
