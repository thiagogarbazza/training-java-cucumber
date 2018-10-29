package com.github.thiagogarbazza.trainings.cucumber.dominio.util.periodo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Data
@Builder
@EqualsAndHashCode(of = {"inicio", "fim"})
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class Periodo {

  @Column(name = "fim")
  private LocalDate fim;

  @Column(name = "inicio")
  private LocalDate inicio;
}
