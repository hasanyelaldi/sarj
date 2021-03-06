package com.eyakit.sarj.service;

import java.util.List;

import com.eyakit.sarj.exception.UserNotFoundException;
import com.eyakit.sarj.model.Brand;
import com.eyakit.sarj.model.User;

public interface SarjService {
	List<User> findUsers();
	List<User> findUsers(String lastName);
	User findUser(Long id) throws UserNotFoundException;
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(Long id);
	
	List<Brand> findBrands();
	Brand findBrand(Long id) throws UserNotFoundException;
	void createBrand(Brand brand);
	void updateBrand(Brand brand);
}
