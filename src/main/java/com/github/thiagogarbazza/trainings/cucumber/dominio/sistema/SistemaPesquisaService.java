package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema;

import java.util.Collection;

public interface SistemaPesquisaService {

  Collection<Sistema> pesquisar(SistemaFiltroPesquisa filtro);
}
