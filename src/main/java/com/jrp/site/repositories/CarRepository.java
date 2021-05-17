package com.jrp.site.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrp.site.vehicles.Car;

@Repository
public interface CarRepository extends CrudRepository <Car,Long> {

	@Override
	List<Car> findAll();
	


	@Query(value="select * from Car c where c.price<:keyword",nativeQuery=true)
	List<Car> findByPrice(@Param("keyword")Integer keyword);

	@Query(value="select * from Car c where c.email like %:name%",nativeQuery=true)
	List<Car> findByUser(@Param("name")String name);
	
	
//	void deleteById(@Param("delete")Integer delete);
	
}
