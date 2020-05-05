package com.nnk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
@EncryptablePropertySource(name = "EncryptedProperties", value = "classpath:application.properties")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
