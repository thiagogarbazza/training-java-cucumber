package com.github.thiagogarbazza.trainings.cucumber.dominio;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.github.thiagogarbazza.trainings.cucumber.dominio")
@ComponentScan("com.github.thiagogarbazza.trainings.cucumber.dominio")
public class DominioConfiguracao {
}
