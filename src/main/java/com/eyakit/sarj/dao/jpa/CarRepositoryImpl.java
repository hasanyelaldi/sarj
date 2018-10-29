package com.eyakit.sarj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eyakit.sarj.dao.CarRepository;
import com.eyakit.sarj.model.Car;

@Repository("carRepository")
public class CarRepositoryImpl implements CarRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Car findById(Long id) {
		return entityManager.find(Car.class, id);
	}

	@Override 
	public List<Car> findByUserId(Long userId) {
		return entityManager.createQuery("from User where user.id = :userId", Car.class)
				.setParameter("userId", userId).getResultList();
	}

	@Override
	public void create(Car car) {
		entityManager.persist(car);
	}

	@Override
	public Car update(Car car) {
		return entityManager.merge(car);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Car.class, id));
	}

	@Override
	public void deleteByUserId(Long userId) {
		entityManager.createQuery("delete from User where user.id = :userId").setParameter("userId", userId)
				.executeUpdate();
	}
}
