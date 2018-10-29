package com.eyakit.sarj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value=SarjProperties.class)
@ServletComponentScan
public class SarjApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SarjApplication.class, args);
	}
}