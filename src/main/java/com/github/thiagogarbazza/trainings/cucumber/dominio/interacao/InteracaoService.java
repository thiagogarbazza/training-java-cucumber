package com.github.thiagogarbazza.trainings.cucumber.dominio.interacao;

public interface InteracaoService {

  Interacao salvar(Interacao interacao);

  Interacao criar(Interacao interacao);

  Interacao alterar(Interacao interacao);

  Interacao detalhar(Long idInteracao);

  void excluir(Interacao interacao);
}
