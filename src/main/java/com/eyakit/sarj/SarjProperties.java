package com.eyakit.sarj;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="sarj")
public class SarjProperties {
	private boolean displayUsersWithCars = false;
	
	public boolean isDisplayUsersWithCars() {
		return displayUsersWithCars;
	}
	
	public void setDisplayUsersWithCars(boolean displayUsersWithCars) {
		this.displayUsersWithCars = displayUsersWithCars;
	}
}
