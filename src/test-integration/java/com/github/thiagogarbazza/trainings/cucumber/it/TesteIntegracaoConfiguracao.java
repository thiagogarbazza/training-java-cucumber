package com.github.thiagogarbazza.trainings.cucumber.it;

import com.github.thiagogarbazza.trainings.cucumber.dominio.DominioConfiguracao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Inherited
@Documented
@Target({TYPE})
@Retention(RUNTIME)
@SpringBootTest
@EnableAutoConfiguration
@Import(DominioConfiguracao.class)
@ComponentScan("com.github.thiagogarbazza.trainings.cucumber.it")
@PropertySource("classpath:application-teste-integracao.properties")
@interface TesteIntegracaoConfiguracao {
}
