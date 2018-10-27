package com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.sistema.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

interface SistemaRepository extends JpaRepository<Sistema, Long>, QuerydslPredicateExecutor<Sistema>, SistemaRepositoryCustom {
}
