package com.jrp.site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.site.repositories.CarRepository;
import com.jrp.site.service.CarService;
import com.jrp.site.service.MotorService;
import com.jrp.site.vehicles.Car;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	CarRepository carRepo;
	
	@Autowired
	CarService carService;
	
	
	@Autowired
	MotorService motoService;

	
//	@PostMapping("/delete")
//	public String addCarToRepo(Integer delete) {
//		
//		carService.delete(delete);
//		
//		//USE TO PREVENT DUBLICATE SUBMISSION
//		return"redirect:/profile/cars";
//		
//	}
//	
	@GetMapping()
	public String profile(Model model) {
	
		String login = "";
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
		login = SecurityContextHolder.getContext().getAuthentication().getName();
		if(login.equals("anonymousUser")) {
			return "login";
			}
		}
		
		model.addAttribute("myprofile",login);
	
		return"profile/myprofile";
	}
	
	@GetMapping("cars")
	public String profileCars(Model model) {
		String login =  SecurityContextHolder.getContext().getAuthentication().getName();
		List<Car> cars = carService.findByUser(login);
		
		
		model.addAttribute("cars",cars);
		
		return "profile/activeprofilecars";
		
	}
	@GetMapping("motors")
	public String profileMotors(Model model) {
		String login =  SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("motors",motoService.findByUser(login));
		return"profile/activeprofilemotors";
		
	}
}
