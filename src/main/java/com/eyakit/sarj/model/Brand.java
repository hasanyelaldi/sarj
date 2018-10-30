package com.eyakit.sarj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_brand")
public class Brand {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sarjSeqGen")
	@SequenceGenerator(name="sarjSeqGen",sequenceName="sarj_sequence")
	private Long id;
	@Column(name="name")
	private String name;
	
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
	
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + "]";
	}
	
}
