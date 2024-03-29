package com.danny.checkinapi;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import annotations.Generated;
import infraestructure.repositories.MetodoPago.MetodoPagoJpaRepository;
import infraestructure.repositories.check.in.CheckInJpaRepository;
import infraestructure.repositories.persona.PersonaJpaRepository;
import infraestructure.repositories.propiedad.PropiedadJpaRepository;
import infraestructure.repositories.tipoPropiedad.TipoPropiedadJpaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Arrays;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repositories.*;

@SpringBootApplication()
@ComponentScan(
    basePackages = {
      "controllers",
      "infraestructure.repositories",
      "use.cases",
      "event",
      "core",
    })
@EntityScan("infraestructure.model")
@EnableJpaRepositories(basePackages = {"infraestructure.repositories"})
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "Check in Domain", version = "1.0.0"))
@Generated
public class CheckInApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(CheckInApiApplication.class, args);
  }

  @Bean(name = "checkInRepository")
  public CheckInRepository checkInRepository() {
    return new CheckInJpaRepository();
  }

  @Bean(name = "passangerRepository")
  public PersonaRepository passangerRepository() {
    return new PersonaJpaRepository();
  }

  @Bean(name = "metodoPagoRepository")
  public MetodoPagoRepository metodoPagoRepository() {
    return new MetodoPagoJpaRepository();
  }

  @Bean(name = "propiedadRepository")
  public PropiedadRepository propiedadRepository() {
    return new PropiedadJpaRepository();
  }

  @Bean(name = "tipoPropiedadRepository")
  public TipoPropiedadRepository tipoPropiedadRepository() {
    return new TipoPropiedadJpaRepository();
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }

  @Bean
  Pipeline pipeline(
      ObjectProvider<Command.Handler> commandHandlers,
      ObjectProvider<Notification.Handler> notificationHandlers,
      ObjectProvider<Command.Middleware> middlewares) {
    return new Pipelinr()
        .with(commandHandlers::stream)
        .with(notificationHandlers::stream)
        .with(middlewares::orderedStream);
  }
}
