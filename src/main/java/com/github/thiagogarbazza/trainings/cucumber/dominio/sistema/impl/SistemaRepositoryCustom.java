package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;

import java.util.Collection;

interface SistemaRepositoryCustom {

  Collection<Sistema> pesquisar(SistemaFiltroPesquisa filtro);
}
