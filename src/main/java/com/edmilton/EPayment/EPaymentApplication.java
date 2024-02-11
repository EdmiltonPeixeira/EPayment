package com.edmilton.EPayment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "EPayment",
				version = "1.0.0",
				description = "API Rest para gerenciamento de pagamentos",
				contact = @Contact(
						name = "Edmilton Ribeiro Peixeira | Desenvolvedor",
						email = "edm.ufpasi@gmail.com"
				)
		)
)
public class EPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EPaymentApplication.class, args);
	}

}
