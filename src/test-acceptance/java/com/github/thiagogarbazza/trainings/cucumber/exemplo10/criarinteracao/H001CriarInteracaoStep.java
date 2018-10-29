package com.github.thiagogarbazza.trainings.cucumber.exemplo10.criarinteracao;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaFiltroPesquisa;
import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaPesquisaService;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.ValidationException;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.periodo.Periodo;
import com.github.thiagogarbazza.trainings.cucumber.exemplo10.TesteAceitacaoConfiguracao;
import com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps.DropBase;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static com.github.thiagogarbazza.trainings.cucumber.LocalDateUtil.toLocalDate;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.junit.Assert.assertEquals;

@TesteAceitacaoConfiguracao
public class H001CriarInteracaoStep {

  private String msgAoCriar;
  private Interacao interacao;
  private Interacao.InteracaoBuilder interacaoBuilder;
  @Autowired
  private InteracaoService interacaoService;
  private Periodo.PeriodoBuilder periodoBuilder;
  @Autowired
  private SistemaPesquisaService sistemaPesquisaService;

  @Autowired
  private DropBase dropBase;

  @Before
  public void before() {
    dropBase.limparBase();

    interacaoBuilder = Interacao.builder();
    periodoBuilder = Periodo.builder();

    interacao = null;
    msgAoCriar = null;
  }

  @Quando("^clicar no botão salvar\\.$")
  public void clicarNoBotaoSalvar() {
    interacaoBuilder.periodo(periodoBuilder.build());
    try {
      interacao = interacaoService.criar(interacaoBuilder.build());
      msgAoCriar = "Interação cadastrada com sucesso.";
    } catch (ValidationException e) {
      msgAoCriar = e.getMessage();
    }
  }

  @E("^informou a data de fim \"(.*)\"\\.$")
  public void informouADataDeFim(String data) {
    periodoBuilder.fim(toLocalDate(data));
  }

  @E("^informou a data de início \"(.*)\"\\.$")
  public void informouADataDeInicio(String data) {
    periodoBuilder.inicio(toLocalDate(data));
  }

  @E("^informou o nome da interação \"(.*)\"\\.$")
  public void informouONomeDaInteracao(String nome) {
    interacaoBuilder.nome(nome);
  }

  @Entao("^o sistema responde que \"(.*)\"\\.$")
  public void oSistemaRespondQue(String respostaEsperada) {
    assertEquals("Mensagem igual", respostaEsperada, msgAoCriar);
  }

  @E("^selecionou o sistema \"(.*)\"\\.$")
  public void selecionouOSistema(String sistemaSigla) {
    final Collection<Sistema> sistemas = sistemaPesquisaService.pesquisar(SistemaFiltroPesquisa.builder().build());

    interacaoBuilder.sistema(isBlank(sistemaSigla) ? null : sistemas.stream().filter(s -> s.getSigla().equalsIgnoreCase(sistemaSigla)).findFirst().get());
  }
}
