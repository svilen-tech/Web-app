package com.jrp.site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.site.repositories.MotorRepository;
import com.jrp.site.vehicles.Car;
import com.jrp.site.vehicles.Motorcycle;

@Controller
@RequestMapping("/motors")
public class MotorController {

	@Autowired
	MotorRepository motorRepo;
	
	@GetMapping("/add")
	public String addMotorcycle(Model model) {
		Motorcycle motor = new Motorcycle();
	
		model.addAttribute(motor);
		
		return"motors/motor";
	}
	
	@PostMapping("/save")
	public String saveMotorcycleToRepo(Motorcycle motor,Model model) {
		
		motorRepo.save(motor);
		return"redirect:/motors/add";

	}
	@GetMapping()
	public String displayAllMotors(Model model) {
		List<Motorcycle> motors = motorRepo.findAll();
		
		model.addAttribute("motors",motors);
		
		return "motors/home-motors";
		
	}
	
	
	
	
	
	
}
