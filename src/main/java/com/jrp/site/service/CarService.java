package com.jrp.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.jrp.site.repositories.CarRepository;
import com.jrp.site.vehicles.Car;

@Service
public class CarService {

	@Autowired
	CarRepository carRepo;
	
	public Car save(Car car) {
		return carRepo.save(car);
	}
	
//	public void delete(Integer delete) {
//		carRepo.deleteById(delete);
//	}
	
	public List<Car> getAll(){
	return carRepo.findAll();
	}
	
	public List<Car> findByPrice(Integer keyword){
		return carRepo.findByPrice(keyword);
		
	}
	
	public List<Car> findByUser(@Param("name")String name){
		return carRepo.findByUser(name);
	}
	
	public List<Car> findAll(){
		return carRepo.findAll();
	}
}
