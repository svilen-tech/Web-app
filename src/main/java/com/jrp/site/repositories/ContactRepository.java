package com.jrp.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jrp.site.vehicles.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {

}
