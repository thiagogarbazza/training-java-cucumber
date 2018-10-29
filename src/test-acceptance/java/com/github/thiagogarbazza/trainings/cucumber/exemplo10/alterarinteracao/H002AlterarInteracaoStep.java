package com.github.thiagogarbazza.trainings.cucumber.exemplo10.alterarinteracao;

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
public class H002AlterarInteracaoStep {

  @Autowired
  private DropBase dropBase;
  private Interacao interacao;
  @Autowired
  private InteracaoPesquisaService interacaoPesquisaService;
  private Interacao interacaoSalva;
  @Autowired
  private InteracaoService interacaoService;
  private String msgAoAlterar;
  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;

  @Before
  public void before() {
    dropBase.limparBase();

    interacao = null;
    interacaoSalva = null;
    msgAoAlterar = null;
  }

  @Quando("^clicar no botão salvar\\.$")
  public void clicarNoBotaoSalvar() {
    try {
      interacaoSalva = interacaoService.alterar(interacao);
    } catch (ValidationException e) {
      msgAoAlterar = e.getMessage();
    }
  }

  @E("^informou a data de fim \"(.*)\"\\.$")
  public void informouADataDeFim(String data) {
    interacao.getPeriodo().setFim(toLocalDate(data));
  }

  @E("^informou a data de início \"(.*)\"\\.$")
  public void informouADataDeInicio(String data) {
    interacao.getPeriodo().setInicio(toLocalDate(data));
  }

  @E("^informou o nome da interação \"(.*)\"\\.$")
  public void informouONomeDaInteracao(String nome) {
    interacao.setNome(nome);
  }

  @Entao("^o sistema responde que \"(.*)\"\\.$")
  public void oSistemaRespondQue(String respostaEsperada) {
    assertEquals("Mensagem igual", respostaEsperada, msgAoAlterar);
  }

  @Entao("^o sistema responde que a interação foi alterada com sucesso\\.$")
  public void oSistemaRespondQueInteracaoAlteradaComSucesso(DataTable dataTable) {
    final List<String> r = dataTable.cells().stream().skip(1).findFirst().get();

    //assertEquals(Long.valueOf(r.get(0)), interacao.getPk());
    assertEquals(r.get(1), interacao.getSistema().getSigla());
    assertEquals(toLocalDate(r.get(2)), interacao.getPeriodo().getInicio());
    assertEquals(toLocalDate(r.get(3)), interacao.getPeriodo().getFim());
    assertEquals(r.get(4), interacao.getNome());
  }

  @E("^solicita alteração da interação \"(.*)\" do sistema \"(.*)\"\\.$")
  public void solicitaAlteracaoDaInteracaoDoSistema(String nomeInteracao, String siglaSistema) {
    final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(SistemaFiltroPesquisa.builder().texto(siglaSistema).build());

    final Collection<Interacao> interacoes = interacaoPesquisaService.pesquisar(InteracaoFiltro.builder()
        .sistema(sistemas.stream().findFirst().get().getPk())
        .nome(nomeInteracao)
        .build());

    interacao = interacoes.stream().findFirst().get();
  }
}
