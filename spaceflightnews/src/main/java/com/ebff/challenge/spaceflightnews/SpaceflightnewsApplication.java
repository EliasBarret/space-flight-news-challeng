package com.ebff.challenge.spaceflightnews;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "SpaceFlight News REST API", version = "1.0.0", description = "Documentation for the Spaceflight News API by Elias Barret",
					contact = @Contact(
						name = "Elias Barreto",
						email = "elias-barreto@outlook.com"),
					license = @License(
						url = "http://www.apache.org/licenses/LICENSE-2.0.html",
						name = "Apache 2.0")))
@EnableScheduling
public class SpaceflightnewsApplication {

	public static void main(String[] args) {SpringApplication.run(SpaceflightnewsApplication.class, args);}
}
