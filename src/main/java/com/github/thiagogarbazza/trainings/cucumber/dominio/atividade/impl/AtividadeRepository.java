package com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.atividade.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

interface AtividadeRepository extends JpaRepository<Atividade, Long>, QuerydslPredicateExecutor<Atividade>, AtividadeRepositoryCustom {
}
