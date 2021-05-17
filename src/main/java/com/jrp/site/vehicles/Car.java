package com.jrp.site.vehicles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="car_seq")
	@SequenceGenerator(name = "car_seq", allocationSize = 1)
	private long carId;

	private String brand;
	
	private String model;
	private int hp;
	private int mileage;
	private int cubic;
	private String color;
	private String fuel;
	private String transmission;
	private int price;
	private String email;
	
	
	
	public Car() {
		
	}
	
	
	
	
	public Car(String brand, String model, int hp, int mileage, int cubic, String color, String fuel,
			String transmission,int price,String email) {
		super();
		this.brand = brand;
		this.model = model;
		this.hp = hp;
		this.mileage = mileage;
		this.cubic = cubic;
		this.color = color;
		this.fuel = fuel;
		this.transmission = transmission;
		this.price=price;
		this.email=email;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}




	public Long getId() {
		return carId;
	}
	public void setId(long id) {
		this.carId = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getCubic() {
		return cubic;
	}
	public void setCubic(int cubic) {
		this.cubic = cubic;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	
}
