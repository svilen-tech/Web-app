package com.jrp.site.vehicles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Motorcycle {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="motorcycle_seq")
	@SequenceGenerator(name = "motorcycle_seq", allocationSize = 1)
	private long motorcycleId;
	
	
	private String brand;
	private String model;
	private String type;
	private String color;
	private String dateOfProduction;
	private int cubic;
	private int hp;
	private int price;
	private String email;
	
	public Motorcycle() {
		
	}
	



	public Motorcycle(String brand, String model, String type, String color, String dateOfProduction, int cubic, int hp,
			int price,String email) {
		super();
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.color = color;
		this.dateOfProduction = dateOfProduction;
		this.cubic = cubic;
		this.hp = hp;
		this.price = price;
		this.email=email;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}




	public String getDateOfProduction() {
		return dateOfProduction;
	}




	public void setDateOfProduction(String dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}




	public long getId() {
		return motorcycleId;
	}


	public void setId(long motorcycleId) {
		this.motorcycleId = motorcycleId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getCubic() {
		return cubic;
	}


	public void setCubic(int cubic) {
		this.cubic = cubic;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
