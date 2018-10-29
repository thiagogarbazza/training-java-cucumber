package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoPesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class InteracaoPesquisaServiceImpl implements InteracaoPesquisaService {

  @Autowired
  private InteracaoRepository repository;

  @Autowired
  private InteracaoValidacao validacao;

  @Override
  public Collection<Interacao> pesquisar(final InteracaoFiltro filtro) {
    return repository.pesquisar(filtro);
  }

  @Override
  public Collection<Interacao> pesquisarValidando(final InteracaoFiltro filtro) {
    validacao.aoPesquisar(filtro);
    return pesquisar(filtro);
  }
}
