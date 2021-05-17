package com.jrp.site.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.site.service.UserService;
import com.jrp.site.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
 
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService=userService;
	}
	
	@ModelAttribute("username")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("username") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
