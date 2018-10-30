package com.eyakit.sarj.dao;

import java.util.List;

import com.eyakit.sarj.model.Brand;

public interface BrandRepository {
	List<Brand> findAll();
	Brand findById(Long id);
	void create(Brand user);
	Brand update(Brand user);
	void delete(Long id);
}
