package com.github.thiagogarbazza.trainings.cucumber.exemplo10.comumsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DropBase {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void limparBase(){
    jdbcTemplate.execute("DELETE FROM training_cucumber.tbl_atividade");
    jdbcTemplate.execute("DELETE FROM training_cucumber.tbl_interacao");
    jdbcTemplate.execute("DELETE FROM training_cucumber.tbl_sistema");
  }
}
