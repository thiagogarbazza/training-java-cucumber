package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class AtividadeServiceImpl implements AtividadeService {

  @Autowired
  private AtividadeRepository repository;

  @Override
  public Atividade salvar(final Atividade atividade) {
    return repository.save(atividade);
  }
}
