package com.jrp.site.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jrp.site.repositories.UserRepository;
import com.jrp.site.userModel.Role;
import com.jrp.site.userModel.Username;
import com.jrp.site.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	

	@Override
	public Username save(UserRegistrationDto registrationDto) {
		Username user  = new Username(registrationDto.getFirstName(),
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode	(registrationDto.getPassword()),Arrays.asList(new Role("ROLE_USERNAME")));
		
		return userRepository.save(user);
	}

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Username user = userRepository.findByEmail(username);
		if(user==null) {
			
		throw new UsernameNotFoundException("Invalid username or password.");
	
		}
		
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
}
