package com.example.springbootmvcassignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@NotBlank
	@Size(min=3, max=50)
	String name;
	@NotBlank
	@Size(min=3, max=50)
	String capitol;
	@Min(value=100)
	@Max(value=1_999_999_999)
	Long population;
	
	public Country() {}
	
	public Country(int id, String name, String capitol, Long population) {
		this.id=id;
		this.name=name;
		this.capitol=capitol;
		this.population=population;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapitol() {
		return capitol;
	}
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
}
