package com.eyakit.sarj;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SarjConfiguration {
	@Autowired
	private SarjProperties sarjProperties;
	
	@PostConstruct
	public void init() {
		System.out.println("Display users with cars :" + sarjProperties.isDisplayUsersWithCars());
	}
}