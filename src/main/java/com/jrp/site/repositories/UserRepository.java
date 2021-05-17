package com.jrp.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrp.site.userModel.Username;

@Repository
public interface UserRepository extends JpaRepository<Username,Long>{
	Username findByEmail(String email);
	
}
