package com.eyakit.sarj.dao;

import java.util.List;

import com.eyakit.sarj.model.Car;

public interface CarRepository {
	Car findById(Long id);
	List<Car> findByUserId(Long userId);
	void create(Car car);
	Car update(Car car);
	void delete(Long id);
	void deleteByUserId(Long userId);
}
