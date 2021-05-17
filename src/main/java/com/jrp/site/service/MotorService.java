package com.jrp.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.jrp.site.repositories.MotorRepository;
import com.jrp.site.vehicles.Car;
import com.jrp.site.vehicles.Motorcycle;

@Service
public class MotorService {

	@Autowired
	MotorRepository motoRepo;
	
	public Motorcycle save(Motorcycle motor) {
		return motoRepo.save(motor);
	}
	
	
	public List<Motorcycle> getAll(){
	return motoRepo.findAll();
	}
	
	public List<Motorcycle> findByPrice(Integer keyword){
		return motoRepo.findByPrice(keyword);
		
	}
	public List<Motorcycle> findByUser(@Param("name")String name){
		return motoRepo.findByUser(name);
	}
}
