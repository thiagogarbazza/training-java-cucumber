package com.github.thiagogarbazza.trainings.cucumber.exemplo10;

import com.github.thiagogarbazza.trainings.cucumber.dominio.DominioConfiguracao;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.test.context.junit4.SpringRunner;

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
@RunWith(SpringRunner.class)
@Import(DominioConfiguracao.class)
@ComponentScan("com.github.thiagogarbazza.trainings.cucumber.at")
@PropertySource("classpath:application-teste-aceitacao.properties")
public @interface TesteAceitacaoConfiguracao {
}
