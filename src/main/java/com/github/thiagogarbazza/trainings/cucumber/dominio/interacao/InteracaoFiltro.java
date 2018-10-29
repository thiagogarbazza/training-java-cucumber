package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class InteracaoFiltro {

  private String nome;
  private Long sistema;
}
