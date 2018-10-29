package com.github.thiagogarbazza.trainings.cucumber.exemplo10.pesquisarinteracao;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoPesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaPesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.ValidationException;
import com.github.thiagogarbazza.trainings.cucumber.exemplo10.TesteAceitacaoConfiguracao;
import com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps.DropBase;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.junit.Assert.assertEquals;

@TesteAceitacaoConfiguracao
public class H005PesquisarInteracaoStep {

  @Autowired
  private DropBase dropBase;
  private InteracaoFiltro.InteracaoFiltroBuilder interacaoFiltroBuilder;
  @Autowired
  private InteracaoPesquisaService interacaoPesquisaService;
  private Collection<Interacao> interacoes;
  private String msgAoPesquisar;
  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;

  @Before
  public void before() {
    dropBase.limparBase();

    interacaoFiltroBuilder = InteracaoFiltro.builder();
    interacoes = null;
  }

  @Quando("^clicar no botão pesquisar\\.$")
  public void clicarNoBotaoDetalhar() {
    try {
      interacoes = interacaoPesquisaService.pesquisarValidando(interacaoFiltroBuilder.build());
    } catch (ValidationException e) {
      msgAoPesquisar = e.getMessage();
    }
  }

  @Entao("^o sistema responde que \"(.*)\"\\.$")
  public void oSistemaRespondQue(String respostaEsperada) {
    assertEquals("Mensagem igual", respostaEsperada, msgAoPesquisar);
  }

  @Entao("^o sistema responde as interações abaixo:$")
  public void oSistemaRespondeAsInteracoesAbaixo(DataTable dataTable) {
    assertEquals(dataTable.cells().size() -1, interacoes.size());
  }

  @E("^informou o filtro nome \"(.*)\"\\.$")
  public void selecionouOfiltroNome(String nome) {
    interacaoFiltroBuilder.nome(nome);
  }

  @E("^selecionou o filtro sistema \"(.*)\"\\.$")
  public void selecionouOfiltroSistema(String siglaSistema) {
    if (isNotBlank(siglaSistema)) {
      final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(SistemaFiltroPesquisa.builder().texto(siglaSistema).build());
      interacaoFiltroBuilder.sistema(sistemas.stream().findFirst().get().getPk());
    }
  }
}
