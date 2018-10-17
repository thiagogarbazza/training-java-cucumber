package com.github.thiagogarbazza.trainings.cucumber.exemplo01;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class CalendarioService {

  private static CalendarioService INSTANCE = new CalendarioService();

  public boolean eFeriado(LocalDate localDate) {
    return false;
  }

  public static CalendarioService getCalendarioService() {
    return INSTANCE;
  }
}
