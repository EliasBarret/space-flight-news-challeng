package com.ebff.challenge.spaceflightnews;

import com.ebff.challenge.spaceflightnews.support.CronJobSync;
import com.mongodb.client.MongoClient;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "Space Flight News API", version = "1.0.0", description = "API to manage articles about space"))
@EnableScheduling
public class SpaceflightnewsApplication {

	public static void main(String[] args) {SpringApplication.run(SpaceflightnewsApplication.class, args);}
}
