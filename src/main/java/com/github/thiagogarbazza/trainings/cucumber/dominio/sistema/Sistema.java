package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema;

import com.github.thiagogarbazza.trainings.cucumber.dominio.util.AbstractDominio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Entity(name = "sis")
@Table(name = "tbl_sistema")
public class Sistema extends AbstractDominio {

  @Column(name = "nome")
  private String nome;

  @Column(name = "sigla")
  private String sigla;

  @Column(name = "situacao")
  @Enumerated(EnumType.STRING)
  private SituacaoSistema situacao;
}
