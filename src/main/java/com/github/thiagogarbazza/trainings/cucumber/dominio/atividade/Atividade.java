package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.AbstractDominio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Entity(name = "ati")
@Table(name = "tbl_atividade")
public class Atividade extends AbstractDominio {

  @ManyToOne(optional = false)
  @JoinColumn(name = "intId", nullable = false)
  private Interacao interacao;

  @Column(name = "nome")
  private String nome;

  @Column(name = "storyPoints")
  private Integer storyPoints;
}
