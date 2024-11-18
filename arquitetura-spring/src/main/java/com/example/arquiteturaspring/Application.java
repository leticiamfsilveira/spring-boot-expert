package com.example.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		// faz a mesma coisa que a linha 11
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		// mudar  banner que aparece no console
		builder.bannerMode(Banner.Mode.OFF);

		// pegar beans dentro do container spring
		// var produtoRepository = applicationContext.getBean("produtoRepository");

		// exemplo: subir a aplicação em modo produção -> não é o ideal rodar aqui (apenas debug)
		builder.profiles("producao");

		// os parâmetros args podem ser passados em um container docker, se necessário
		builder.run(args);

		// acesso ao contexto da aplicação já iniciada
		ConfigurableApplicationContext applicationContext = builder.context();

		// dentro do enviroment é permitido conseguir ler qualquer propriedade
		ConfigurableEnvironment environment = applicationContext.getEnvironment();

		// propriedade do aplication.properties
		String applicationName = environment.getProperty("spring.application.name");

		System.out.println("Nome da aplicação: " + applicationName);
	}

}
