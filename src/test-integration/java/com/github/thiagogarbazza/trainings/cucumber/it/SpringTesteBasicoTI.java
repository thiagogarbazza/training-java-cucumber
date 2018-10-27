package com.github.thiagogarbazza.trainings.cucumber.it;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.SistemaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@TesteIntegracaoConfiguracao
@RunWith(SpringRunner.class)
public class SpringTesteBasicoTI {

  @Autowired
  private SistemaService sistemaService;

  @Test
  public void verificarFuncionamentoDoSpring() {
    assertNotNull(sistemaService);
  }
}
