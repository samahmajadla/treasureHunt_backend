package com.smaj.treasureHunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class TreasureHuntApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TreasureHuntApplication.class);
		app.setApplicationContextFactory((type)-> new AnnotationConfigWebApplicationContext());
		app.run(args);
	}

}
