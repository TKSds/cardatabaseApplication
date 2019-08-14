package com.ds.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.cardatabase.domain.Car;
import com.ds.cardatabase.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepository.findAll();
	}
	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable Long id) {
		carRepository.deleteById(id);
	}

}
