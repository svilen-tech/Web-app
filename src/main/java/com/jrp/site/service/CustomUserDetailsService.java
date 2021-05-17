package com.jrp.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jrp.site.repositories.UserRepository;
import com.jrp.site.userModel.Username;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Username customer = userRepo.findByEmail(email);
		if(customer==null) {
			throw new UsernameNotFoundException(email);
		}
		UserDetails user = User.withUsername(customer.getEmail())
				.password(customer.getPassword())
				.authorities("USER").build();
		return user;
	}


}
