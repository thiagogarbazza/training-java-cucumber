package com.github.thiagogarbazza.trainings.cucumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class LocalDateUtil {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static LocalDate toLocalDate(String data) {
    if (isBlank(data)) {
      return null;
    }

    return LocalDate.parse(data, DATE_FORMAT);
  }
}
