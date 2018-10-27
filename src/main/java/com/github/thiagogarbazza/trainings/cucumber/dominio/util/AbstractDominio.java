package com.github.thiagogarbazza.trainings.cucumber.dominio.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@MappedSuperclass
public abstract class AbstractDominio implements Serializable {

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  private Long pk;
}
