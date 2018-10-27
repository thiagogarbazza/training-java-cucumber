package com.github.thiagogarbazza.trainings.cucumber.it;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaPesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SituacaoSistema.ATIVO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@TesteIntegracaoConfiguracao
@RunWith(SpringRunner.class)
public class TestePersistenciaTI {

  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;
  @Autowired
  private SistemaService sistemaService;

  @Test
  public void verificarPesquisa() {
    SistemaFiltroPesquisa filtro = SistemaFiltroPesquisa.builder().texto("SDN").build();

    final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(filtro);
    assertNotNull(sistemas);
    assertEquals(1, sistemas.size());
    assertEquals("SDN", sistemas.iterator().next().getSigla());
  }

  @Test
  public void verificarSalvar() {
    Sistema sistema = Sistema.builder()
        .sigla("SIS")
        .nome("Nome do sistema")
        .situacao(ATIVO)
        .build();

    final Sistema sistemaSalvo = sistemaService.salvar(sistema);
    assertNotNull(sistemaSalvo.getPk());
  }
}
