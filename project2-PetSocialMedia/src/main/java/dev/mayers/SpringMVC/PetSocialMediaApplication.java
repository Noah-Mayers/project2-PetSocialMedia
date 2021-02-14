package dev.mayers.SpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.groupone")
@EnableJpaRepositories("dev.groupone.repositories")
@EntityScan("dev.groupone.beans")
public class PetSocialMediaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(PetSocialMediaApplication.class, args);
	}

}
