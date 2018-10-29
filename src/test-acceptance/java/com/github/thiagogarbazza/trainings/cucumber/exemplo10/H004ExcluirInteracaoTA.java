package com.github.thiagogarbazza.trainings.cucumber.exemplo10;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:com/github/thiagogarbazza/trainings/cucumber/exemplo10/H004ExcluirInteracaoTA.feature",
    glue = {
        "classpath:com/github/thiagogarbazza/trainings/cucumber/exemplo10/excluirinteracao",
        "classpath:com/github/thiagogarbazza/trainings/cucumber/exemplo10/comumsteps"
    })
public class H004ExcluirInteracaoTA {
}
