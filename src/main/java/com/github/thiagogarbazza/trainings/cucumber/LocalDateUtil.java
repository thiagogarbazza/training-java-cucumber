package com.github.thiagogarbazza.trainings.cucumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static LocalDate toLocalDate(String date) {
    return LocalDate.parse(date, DATE_FORMAT);
  }
}
