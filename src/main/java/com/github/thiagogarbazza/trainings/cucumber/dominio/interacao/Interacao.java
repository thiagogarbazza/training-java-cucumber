package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.AbstractDominio;
import com.github.thiagogarbazza.trainings.cucumber.dominio.util.periodo.Periodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Entity(name = "int")
@Table(name = "tbl_interacao")
public class Interacao extends AbstractDominio {

  @Column(name = "nome")
  private String nome;

  @Embedded
  private Periodo periodo;

  @ManyToOne(optional = false)
  @JoinColumn(name = "sisId", nullable = false)
  private Sistema sistema;
}
