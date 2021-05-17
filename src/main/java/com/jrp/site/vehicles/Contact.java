package com.jrp.site.vehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="contact_seq")
	@SequenceGenerator(name = "contact_seq", allocationSize = 1)
	private Long contactId;
	
	private String firstName;
	private String lastName;
	private String email;
	private Long carId;
	private String subject;
	
	public Contact() {
		
	}
	


	
	public Contact(String firstName, String lastName, String email, Long carId, String subject) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.carId = carId;
		this.subject = subject;
	}




	public Long getCarId() {
		return carId;
	}




	public void setCarId(Long carId) {
		this.carId = carId;
	}




	public String getSubject() {
		return subject;
	}




	public void setSubject(String subject) {
		this.subject = subject;
	}




	
	public Long getContactId() {
		return contactId;
	}




	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}




	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
