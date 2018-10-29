package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
class InteracaoServiceImpl implements InteracaoService {

  @Autowired
  private InteracaoRepository repository;

  @Autowired
  private InteracaoValidacao validacao;

  @Override
  public Interacao salvar(final Interacao interacao) {
    return repository.save(interacao);
  }

  @Override
  @PreAuthorize("ROLE_001")
  public Interacao criar(final Interacao interacao) {
    validacao.aoCriar(interacao);
    return salvar(interacao);
  }
}
