package com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SituacaoSistema;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;

@CommonsLog
public class SistemaStep {

  @Autowired
  private SistemaService sistemaService;

  @E("^que os sistemas abaixo estão cadastrados:$")
  public void queOsSistemasAbaixoEstaoCadastrados(DataTable dataTable) {
    dataTable.cells().stream().skip(1).forEach(r -> {
      final Sistema sistema = Sistema.builder()
          .sigla(r.get(1))
          .nome(r.get(2))
          .situacao(SituacaoSistema.valueOf(r.get(3).toUpperCase()))
          .build();
      sistema.setPk(Long.valueOf(r.get(0)));

      sistemaService.salvar(sistema);
    });
  }
}
