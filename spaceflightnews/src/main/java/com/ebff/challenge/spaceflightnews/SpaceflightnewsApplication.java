package com.ebff.challenge.spaceflightnews;

import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpaceflightnewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceflightnewsApplication.class, args);
	}

}
