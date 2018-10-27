package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class SistemaServiceImpl implements SistemaService {

  @Autowired
  private SistemaRepository repository;

  @Override
  public Sistema salvar(Sistema sistema) {
    return repository.save(sistema);
  }
}
