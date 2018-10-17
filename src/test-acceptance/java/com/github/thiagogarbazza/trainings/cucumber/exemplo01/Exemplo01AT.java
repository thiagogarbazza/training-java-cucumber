package com.github.thiagogarbazza.trainings.cucumber.exemplo01;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:com/github/thiagogarbazza/trainings/cucumber/exemplo01/Exemplo02AT.feature")
public class Exemplo01AT {
}
