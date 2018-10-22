package com.github.thiagogarbazza.trainings.cucumber.exemplo02;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:com/github/thiagogarbazza/trainings/cucumber/exemplo02/Exemplo02AT.feature")
public class Exemplo02AT {
}
