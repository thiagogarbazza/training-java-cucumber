package com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.AtividadeService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoPesquisaService;
import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class AtividadeStep {

  @Autowired
  private InteracaoPesquisaService interacaoPesquisaService;

  @Autowired
  private AtividadeService atividadeService;

  @E("^que as atividades abaixo estão cadasstradas:$")
  public void queAsInteracoesAbaixoEstaoCadastradas(DataTable dataTable) {
    final Collection<Interacao> interacoes = interacaoPesquisaService.pesquisar(InteracaoFiltro.builder().build());

    dataTable.cells().stream().skip(1).forEach(r -> {
      Atividade atividade = Atividade.builder()
          .interacao(interacoes.stream()
              .filter(i -> i.getSistema().getSigla().equalsIgnoreCase(r.get(1)) && i.getNome().equalsIgnoreCase(r.get(2)))
              .findFirst()
              .get())
          .nome(r.get(3))
          .storyPoints(Integer.valueOf(r.get(4)))
          .build();
      atividade.setPk(Long.valueOf(r.get(0)));

      atividadeService.salvar(atividade);
    });
  }
}
