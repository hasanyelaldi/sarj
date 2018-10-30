package com.eyakit.sarj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eyakit.sarj.dao.BrandRepository;
import com.eyakit.sarj.model.Brand;
import com.eyakit.sarj.model.User;

@Repository("brandRepository")
public class BrandRepositoryImp implements BrandRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Brand> findAll() {
		return entityManager.createQuery("from Brand", Brand.class).getResultList();
	}

	@Override
	public Brand findById(Long id) {
		return entityManager.find(Brand.class, id);
	}

	@Override
	public void create(Brand brand) {
		entityManager.persist(brand);
	}

	@Override
	public Brand update(Brand brand) {
		return entityManager.merge(brand);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Brand.class, id));
	}

}
