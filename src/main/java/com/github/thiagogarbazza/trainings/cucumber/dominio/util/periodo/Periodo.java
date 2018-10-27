package com.github.thiagogarbazza.trainings.cucumber.dominio.util.periodo;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Periodo {

  @Column(name = "fim")
  private LocalDate fim;

  @Column(name = "inicio")
  private LocalDate inicio;
}
