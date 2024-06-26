package com.inhyekang.myfintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MyfintechApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfintechApplication.class, args);
	}

}