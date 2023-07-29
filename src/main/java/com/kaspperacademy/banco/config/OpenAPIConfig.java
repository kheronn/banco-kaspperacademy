package com.kaspperacademy.banco.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
	
	@Value("${kaspper.opeanapi.dev-url}")
	public String devUrl;
	
	@Value("${kaspper.opeanapi.prod-url}")
	public String prodUrl;
	
	@Bean
	public OpenAPI myOpenAPI() {
		Server devServ = new Server();
		devServ.setUrl(devUrl);
		devServ.setDescription("URL de Desenvolvimento");
		
		Server prodServ = new Server();
		prodServ.setUrl(prodUrl);
		prodServ.setDescription("URL de produção");
		
		Contact contato = new Contact();
		contato.setEmail("desenvolvedor@email.com");
		contato.setName("Kheronn K. Machado");
		contato.setUrl("profkheronn.com");
		
		Info info = new Info()
				.title("API de Apontamentos Kaspper Academy ")
				.version("1.0")
				.contact(contato)
				.description("API para endpoints de apontamentos");
		
		return new OpenAPI()
				.info(info)
				.servers(List.of(devServ,prodServ));

		
	}

}
