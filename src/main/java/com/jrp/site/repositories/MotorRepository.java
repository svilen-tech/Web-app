package com.jrp.site.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jrp.site.vehicles.Car;
import com.jrp.site.vehicles.Motorcycle;

public interface MotorRepository extends CrudRepository<Motorcycle,Long> {
	@Override
	public List<Motorcycle> findAll();
	
	@Query(value="select * from Motorcycle m where m.price<:keyword",nativeQuery=true)
	List<Motorcycle> findByPrice(@Param("keyword")Integer keyword);
	

	@Query(value="select * from Motorcycle m where m.email like %:name%",nativeQuery=true)
	List<Motorcycle> findByUser(@Param("name")String name);
}
