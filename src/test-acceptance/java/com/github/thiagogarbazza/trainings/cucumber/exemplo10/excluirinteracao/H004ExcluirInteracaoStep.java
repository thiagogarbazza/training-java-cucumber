package com.github.thiagogarbazza.trainings.cucumber.exemplo10.excluirinteracao;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoFiltro;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoPesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoService;
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
import java.util.List;

import static com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil.toLocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@TesteAceitacaoConfiguracao
public class H004ExcluirInteracaoStep {

  @Autowired
  private DropBase dropBase;
  private Long idInteracao;
  private Interacao interacao;
  @Autowired
  private InteracaoPesquisaService interacaoPesquisaService;
  @Autowired
  private InteracaoService interacaoService;
  private String msgAoExcluir;
  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;

  @Before
  public void before() {
    dropBase.limparBase();

    interacao = null;
    idInteracao = null;
    msgAoExcluir = null;
  }

  @Quando("^clicar no botão excluir\\.$")
  public void clicarNoBotaoExcluir() {
    try {
      interacaoService.excluir(interacao);
    } catch (ValidationException e) {
      msgAoExcluir = e.getMessage();
    }
  }

  @Entao("^o sistema responde que \"(.*)\"\\.$")
  public void oSistemaRespondQue(String respostaEsperada) {
    assertEquals("Mensagem igual", respostaEsperada, msgAoExcluir);
  }

  @E("^solicita a exclusão da interação \"(.*)\" do sistema \"(.*)\"\\.$")
  public void solicitaAExclusaoDaInteracaoDoSistema(String nomeInteracao, String siglaSistema) {
    final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(SistemaFiltroPesquisa.builder().texto(siglaSistema).build());

    final Collection<Interacao> interacoes = interacaoPesquisaService.pesquisar(InteracaoFiltro.builder()
        .sistema(sistemas.stream().findFirst().get().getPk())
        .nome(nomeInteracao)
        .build());

    idInteracao = interacoes.stream().findFirst().get().getPk();
    interacao = interacaoService.detalhar(idInteracao);
  }

  @Entao("^o sistema responde que a interação foi excluída com sucesso\\.$")
  public void oSistemaRespondQueInteracaoAlteradaComSucesso() {
    interacao = interacaoService.detalhar(idInteracao);
    assertNull(interacao);
  }
}
