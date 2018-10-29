package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.impl;

import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.Interacao;
import com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.InteracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.github.thiagogarbazza.trainings.cucumber.dominio.interacao.QInteracao.interacao;

@Service
class InteracaoServiceImpl implements InteracaoService {

  @Autowired
  private InteracaoRepository repository;

  @Autowired
  private InteracaoValidacao validacao;

  @Override
  public Interacao salvar(final Interacao interacao) {
    return repository.save(interacao);
  }

  @Override
  @PreAuthorize("ROLE_001")
  public Interacao criar(final Interacao interacao) {
    validacao.aoCriar(interacao);
    return salvar(interacao);
  }

  @Override
  @PreAuthorize("ROLE_001")
  public Interacao alterar(final Interacao interacao) {
    validacao.aoAlterar(interacao);
    return salvar(interacao);
  }

  @Override
  @PreAuthorize("ROLE_001")
  public Interacao detalhar(final Long idInteracao) {
    final Optional<Interacao> optional = repository.findOne(interacao.pk.eq(idInteracao));
    return optional.isPresent() ? optional.get() : null;
  }

  @Override
  @PreAuthorize("ROLE_001")
  public void excluir(final Interacao interacao) {
    validacao.aoExcluir(interacao);
    repository.delete(interacao);
  }
}
