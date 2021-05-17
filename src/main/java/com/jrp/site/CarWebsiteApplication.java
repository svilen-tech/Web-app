package com.jrp.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jrp.site.repositories.CarRepository;
import com.jrp.site.repositories.MotorRepository;
import com.jrp.site.vehicles.Car;
import com.jrp.site.vehicles.Motorcycle;

@SpringBootApplication
public class CarWebsiteApplication {
	
	@Autowired
	CarRepository carsRepo;
	@Autowired
	MotorRepository motoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CarWebsiteApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		
		return args ->{
			
			Car car = new Car("BMW", "M3", 478, 80000, 3500,"Blue", "Gasoline",
					"Auto",40000,"some@abv.bg");
			
			Car car1 = new Car("Mercedes", "C-class", 278, 20000, 2500,"White", "Diesel",
					"Auto",15000,"some2@gmail.com");
			
			
			Car car2 = new Car("Audi", "A3", 178, 45800, 2000,"Brown", "Diesel",
					"Auto",8000,"some@abv.bg");
			
			
			Car car3 = new Car("Citroen", "Ctrox", 78, 204000, 1500,"Yellow", "Gasoline",
					"Manual",1500,"some@abv.bg");
			
			
			Car car4 = new Car("Renault", "19", 58, 340400, 1600,"Blue", "Gasoline",
					"Auto",500,"some@abv.bg");
			
			
			Car car5 = new Car("Tesla", "ModelT", 400, 20000, 0,"white", "Other",
					"Auto",100000,"some@abv.bg");
			
		
			
			
			Motorcycle motor = new Motorcycle("Honda","CBR","Sport","Red","2007",600,126,7000,"some@abv.bg");

			Motorcycle motor1 = new Motorcycle("Honda","Hornet","Standard","Yellow","2001",600,98,3500,"some@abv.bg");

			Motorcycle motor2 = new Motorcycle("Kawasaki","Ninja","Sport","Green","2017",1000,198,20000,"some@abv.bg");

			Motorcycle motor3 = new Motorcycle("Suzuki","GSXR","Sport","Blue","2009",750,160,9000,"some@abv.bg");

			Motorcycle motor4 = new Motorcycle("Yamaha","R1","Sport","Yellow","2010",1000,180,12000,"some@abv.bg");

			Motorcycle motor5 = new Motorcycle("KTM","450","Supermoto","Black","2015",450,78,7000,"some@abv.bg");
			
			motoRepo.save(motor);
			motoRepo.save(motor1);
			motoRepo.save(motor2);
			motoRepo.save(motor3);
			motoRepo.save(motor4);
			motoRepo.save(motor5);
			
			
			
			
			
			carsRepo.save(car);
			carsRepo.save(car1);
			carsRepo.save(car2);
			carsRepo.save(car3);
			carsRepo.save(car4);
			carsRepo.save(car5);
			
		};
	}
	
	
}
