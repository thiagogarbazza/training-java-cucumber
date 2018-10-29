package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

interface InteracaoRepository extends JpaRepository<Interacao, Long>, QuerydslPredicateExecutor<Interacao>, InteracaoRepositoryCustom {
}
