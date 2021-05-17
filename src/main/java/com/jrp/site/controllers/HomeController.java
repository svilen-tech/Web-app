package com.jrp.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrp.site.repositories.ContactRepository;
import com.jrp.site.service.CarService;
import com.jrp.site.service.MotorService;
import com.jrp.site.vehicles.Contact;

@Controller
public class HomeController {

	@Autowired
	CarService carService;
	
	
	@Autowired
	MotorService motoService;

	@Autowired
	ContactRepository contactRepo;
	
	

	@GetMapping("/login")
	public String login() {
		return"login";
	}
	@GetMapping("/")
	public String home() {
		return "home";
	} 
	
	
	
	
	
	@GetMapping("/contacts")
	public String displayContacts(Model model) {
		
		Contact contact = new Contact();
		
		model.addAttribute("contact",contact);
		return"contact";
	}
	
	@PostMapping("/contacts/save")
	public String saveContact(Contact contact,Model model) {
		contactRepo.save(contact);
		
		return"redirect:/";
		
	}
	
	
	
	@GetMapping("/searching")
	public String searching(Model model,String type, Integer keyword) {
		
		if(type.equals("car")) {
			if(keyword !=null) {
				model.addAttribute("cars",carService.findByPrice(keyword));
			}else {
			 model.addAttribute("cars",carService.getAll());
			}
			 return"/cars/home-searching-cars";
		}else {
			if(keyword !=null) {
				model.addAttribute("motors",motoService.findByPrice(keyword));
			}else {
			 model.addAttribute("motors",motoService.getAll());
			}
			return"/motors/home-searching-motors";
		}
		
		
		
	}
	
	
}