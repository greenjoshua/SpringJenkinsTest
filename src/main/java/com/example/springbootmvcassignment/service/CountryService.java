package com.example.springbootmvcassignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmvcassignment.model.Country;
import com.example.springbootmvcassignment.repo.CountryRepo;

@Service
public class CountryService {
	@Autowired
	CountryRepo countRepo;
	
	public List<Country> getCountryList() {
		return countRepo.findAll();
	}
	public Country getCountry(int id) {
		return countRepo.findById(id).get();
	}
	public Country get(int id) {
		return countRepo.getById(id);
	}
	public void saveCountry(Country c) {
		countRepo.save(c);
	}
}
