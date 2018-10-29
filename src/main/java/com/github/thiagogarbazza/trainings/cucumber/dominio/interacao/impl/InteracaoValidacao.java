package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.AtividadePesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.integracao.calendario.CalendarioAdapter;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SituacaoSistema.ATIVO;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
class InteracaoValidacao {

  @Autowired
  private AtividadePesquisaService atividadePesquisaService;
  @Autowired
  private CalendarioAdapter calendarioAdapter;

  public void aoAlterar(final Interacao interacao) {
    dataInicioDeveSerInformada(interacao);
    dataFimDeveSerInformada(interacao);
    dataInicioDeveSerDiaUtil(interacao);
    dataFimDeveSerDiaUtil(interacao);
    nomeDeveSerInformado(interacao);
  }

  public void aoCriar(Interacao interacao) {
    sistemaDeveSerInformado(interacao);
    sistemaDeveEstarAtivo(interacao);
    dataInicioDeveSerInformada(interacao);
    dataFimDeveSerInformada(interacao);
    dataInicioDeveSerDiaUtil(interacao);
    dataFimDeveSerDiaUtil(interacao);
    nomeDeveSerInformado(interacao);
  }

  public void aoExcluir(final Interacao interacao) {
    final Collection<Atividade> atividades = atividadePesquisaService.pesquisar(interacao);
    if (isNotEmpty(atividades)) {
      throw new ValidationException("Não é permitido excluir interação que contenha atividade.");
    }
  }

  public void aoPesquisar(final InteracaoFiltro filtro) {
    if (isBlank(filtro.getNome()) && filtro.getSistema() == null) {
      throw new ValidationException("Deve ser utilizado ao menos 1 filtro.");
    }
  }

  private void dataFimDeveSerDiaUtil(final Interacao interacao) {
    if (!calendarioAdapter.diaUtil(interacao.getPeriodo().getFim())) {
      throw new ValidationException("A data fim deve ser dia útil.");
    }
  }

  private void dataFimDeveSerInformada(final Interacao interacao) {
    if (interacao.getPeriodo().getFim() == null) {
      throw new ValidationException("A data fim deve ser informada.");
    }
  }

  private void dataInicioDeveSerDiaUtil(final Interacao interacao) {
    if (!calendarioAdapter.diaUtil(interacao.getPeriodo().getInicio())) {
      throw new ValidationException("A data início deve ser dia útil.");
    }
  }

  private void dataInicioDeveSerInformada(final Interacao interacao) {
    if (interacao.getPeriodo().getInicio() == null) {
      throw new ValidationException("A data início deve ser informada.");
    }
  }

  private void nomeDeveSerInformado(final Interacao interacao) {
    if (isBlank(interacao.getNome())) {
      throw new ValidationException("O nome deve ser informado.");
    }
  }

  private void sistemaDeveEstarAtivo(final Interacao interacao) {
    if (!ATIVO.equals(interacao.getSistema().getSituacao())) {
      throw new ValidationException("O sistema deve estar ativo.");
    }
  }

  private void sistemaDeveSerInformado(final Interacao interacao) {
    if (interacao.getSistema() == null) {
      throw new ValidationException("O sistema deve ser informado.");
    }
  }
}
