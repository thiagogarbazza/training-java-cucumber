package com.github.thiagogarbazza.trainings.cucumber.exemplo10.detalharinteracao;

import com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil;
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

@TesteAceitacaoConfiguracao
public class H003DetalharInteracaoStep {

  @Autowired
  private DropBase dropBase;
  private Long idInteracao;
  private Interacao interacao;
  @Autowired
  private InteracaoPesquisaService interacaoPesquisaService;
  @Autowired
  private InteracaoService interacaoService;
  private String msgAoDetalhar;
  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;

  @Before
  public void before() {
    dropBase.limparBase();

    interacao = null;
    idInteracao = null;
    msgAoDetalhar = null;
  }

  @Quando("^clicar no botão detalhar\\.$")
  public void clicarNoBotaoDetalhar() {
    try {
      interacao = interacaoService.detalhar(idInteracao);
    } catch (ValidationException e) {
      msgAoDetalhar = e.getMessage();
    }
  }

  @Entao("^o sistema responde que \"(.*)\"\\.$")
  public void oSistemaRespondQue(String respostaEsperada) {
    assertEquals("Mensagem igual", respostaEsperada, msgAoDetalhar);
  }

  @E("^solicita o detalhamento da interação \"(.*)\" do sistema \"(.*)\"\\.$")
  public void solicitaODetalhamentoDaInteracaoDoSistema(String nomeInteracao, String siglaSistema) {
    final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(SistemaFiltroPesquisa.builder().texto(siglaSistema).build());

    final Collection<Interacao> interacoes = interacaoPesquisaService.pesquisar(InteracaoFiltro.builder()
        .sistema(sistemas.stream().findFirst().get().getPk())
        .nome(nomeInteracao)
        .build());

    idInteracao = interacoes.stream().findFirst().get().getPk();
  }

  @Entao("^o sistema responde a interação abaixo:$")
  public void oSistemaRespondQueInteracaoAlteradaComSucesso(DataTable dataTable) {
    final List<String> r = dataTable.cells().stream().skip(1).findFirst().get();

    assertEquals(Long.valueOf(r.get(0)), interacao.getPk());
    assertEquals(r.get(1), interacao.getSistema().getSigla());
    assertEquals(toLocalDate(r.get(2)), interacao.getPeriodo().getInicio());
    assertEquals(toLocalDate(r.get(3)), interacao.getPeriodo().getFim());
    assertEquals(r.get(4), interacao.getNome());
  }
}
