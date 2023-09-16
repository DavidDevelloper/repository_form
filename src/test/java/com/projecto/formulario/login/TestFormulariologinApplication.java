package com.projecto.formulario.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestFormulariologinApplication {

	public static void main(String[] args) {
		SpringApplication.from(FormulariologinApplication::main).with(TestFormulariologinApplication.class).run(args);
	}

}
