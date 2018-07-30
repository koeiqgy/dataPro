package com.koei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ServletComponentScan("com.utils")
public class DataProApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataProApplication.class, args);
	}
}