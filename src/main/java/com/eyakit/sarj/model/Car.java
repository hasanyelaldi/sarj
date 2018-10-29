package com.eyakit.sarj.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name="birth_date")
	private Date birthDate;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Long getId() {
		return id;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", user=" + user + "]";
	}
	
	
}
