package com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps;

import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Map;
import java.util.TreeMap;

import static java.text.MessageFormat.format;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;
import static org.springframework.security.core.context.SecurityContextHolder.createEmptyContext;

@CommonsLog
public class LogarUsuarioStep {

  private static final Map<String, String> USUARIOS = new TreeMap<String, String>() {{
    put("Zoraide Silva", "NAO_AUTORIZADO_NUMCA_SERA");
    put("Thiago Garbazza", "ROLE_001");
  }};

  @Before
  public void before() {
    limpar();
  }

  @E("^que o usuário \"(.*)\" esta logado no sistema\\.$")
  public void queOUsuarioEstaLogadoNoSistema(String nomeUsuario) {
    log.info(format("O usuário {0} está logado no sistema com papel {1}", nomeUsuario, USUARIOS.get(nomeUsuario)));

    logarUsuario(nomeUsuario, USUARIOS.get(nomeUsuario));
  }

  private static void limpar() {
    SecurityContextHolder.setContext(createEmptyContext());
  }

  private static void logarUsuario(String username, String... roles) {
    User user = new User(username, "", true, true, true, true, createAuthorityList(roles));

    Authentication auth = new UsernamePasswordAuthenticationToken(user, "", createAuthorityList(roles));
    SecurityContext securityContext = createEmptyContext();
    securityContext.setAuthentication(auth);
    SecurityContextHolder.setContext(securityContext);
  }
}
