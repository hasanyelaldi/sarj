package com.eyakit.sarj.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sarjSeqGen")
	@SequenceGenerator(name="sarjSeqGen",sequenceName="sarj_sequence")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="year")
	private String year;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	public Long getId() {
		return id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", year=" + year + ", brand=" + brand + "]";
	}
	
	
	
}
