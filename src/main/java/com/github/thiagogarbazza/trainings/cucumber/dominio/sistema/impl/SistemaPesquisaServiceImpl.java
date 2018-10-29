package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.QSistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaPesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class SistemaPesquisaServiceImpl implements SistemaPesquisaService {

  @Autowired
  private SistemaRepository repository;

  @Override
  public Collection<Sistema> pesquisar(final SistemaFiltroPesquisa filtro) {
    return repository.pesquisar(filtro);
  }
}
