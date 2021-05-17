package com.jrp.site.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.site.repositories.CarRepository;
import com.jrp.site.vehicles.Car;

@Controller
@RequestMapping("/cars")
public class CarsController {

	@Autowired
	CarRepository carRepo;
	
	
	//Add car page
	@GetMapping("/add")
	public String carsPage(Model model) {	

		Car aCar = new Car();
		
		model.addAttribute("car", aCar);
		
		return"cars/car";
	}
	
	//Save car
	@PostMapping("/save")
	public String addCarToRepo(Car car, Model model) {
		
		carRepo.save(car);
		
		//USE TO PREVENT DUBLICATE SUBMISSION
		return"redirect:/cars/add";
		
	}
	
	//Display all cars
	@GetMapping()
	public String displayAllCars(Model model) {
		List<Car> cars = carRepo.findAll();
		
		model.addAttribute("cars",cars);
		
		return "cars/home-cars";
		
	}
	
}
