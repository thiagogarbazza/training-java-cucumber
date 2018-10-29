package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao;

import java.util.Collection;

public interface InteracaoPesquisaService {

  Collection<Interacao> pesquisar(InteracaoFiltro filtro);
  Collection<Interacao> pesquisarValidando(InteracaoFiltro filtro);
}
