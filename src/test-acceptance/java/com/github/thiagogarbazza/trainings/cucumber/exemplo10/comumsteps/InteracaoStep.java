package com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaPesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.periodo.Periodo;
import cucumber.api.PendingException;
import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil.toLocalDate;

public class InteracaoStep {

  @Autowired
  private InteracaoService interacaoService;

  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;

  @E("^que as interações abaixo estão cadastradas:$")
  public void queAsInteracoesAbaixoEstaoCadastradas(DataTable dataTable) {
    final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(SistemaFiltroPesquisa.builder().build());

    dataTable.cells().stream().skip(1).forEach(r -> {
      Interacao interacao = Interacao.builder()
          .sistema(sistemas.stream().filter(s -> s.getSigla().equalsIgnoreCase(r.get(1))).findFirst().get())
          .periodo(Periodo.builder().inicio(toLocalDate(r.get(2))).fim(toLocalDate(r.get(3))).build())
          .nome(r.get(4))
          .build();
      interacao.setPk(Long.valueOf(r.get(0)));

      interacaoService.salvar(interacao);
    });
  }
}
