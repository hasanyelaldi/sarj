package com.eyakit.sarj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eyakit.sarj.dao.BrandRepository;
import com.eyakit.sarj.dao.CarRepository;
import com.eyakit.sarj.dao.UserRepository;
import com.eyakit.sarj.exception.UserNotFoundException;
import com.eyakit.sarj.model.Brand;
import com.eyakit.sarj.model.User;

@Service
@Transactional(rollbackFor=Exception.class)
public class SarjServiceImpl implements SarjService {
	
	private UserRepository userRepository;
	private CarRepository carRepository;
	private BrandRepository brandRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Autowired
	public void setBrandRepository(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<User> findUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<User> findUsers(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User findUser(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id);
		if(user == null) {
			throw new UserNotFoundException("User not found with id :" + id);
		}
		return user;
	}

	@Override
	public void createUser(User user) {
		userRepository.create(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.update(user);
	}

	@Override
	public void deleteUser(Long id) {
		carRepository.deleteByUserId(id);
		userRepository.delete(id);
		//if(true) throw new RuntimeException("testing rollback...");
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Brand findBrand(Long id) throws UserNotFoundException {
		Brand brand = brandRepository.findById(id);
		if(brand == null) {
			throw new UserNotFoundException("Brand not found with id :" + id);
		}
		return brand;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Brand> findBrands() {
		return brandRepository.findAll();
	}

	@Override
	public void createBrand(Brand brand) {
		brandRepository.create(brand);
		
	}

	@Override
	public void updateBrand(Brand brand) {
		brandRepository.update(brand);
	}

}
