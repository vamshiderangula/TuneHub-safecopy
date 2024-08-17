package com.kodnest.tunehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kodnest.tunehub")
public class ProjectTuneHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTuneHubApplication.class, args);		
	}

}
