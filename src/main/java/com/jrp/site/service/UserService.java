package com.jrp.site.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jrp.site.userModel.Username;
import com.jrp.site.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	Username save(UserRegistrationDto registrationDto);
		
	
}
