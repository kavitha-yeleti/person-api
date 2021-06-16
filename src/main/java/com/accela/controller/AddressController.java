package com.accela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accela.service.AddressService;
import com.accela.service.PersonService;
import com.accela.exceptions.AddressNotFoundException;
import com.accela.exceptions.PersonNotFoundException;
import com.accela.model.Address;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private PersonService personService;


	@RequestMapping(method=RequestMethod.POST, value="/persons/{personId}/addresses")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Address address,@PathVariable long personId) {
		if(personService.getById(personId)==null) {
			throw new PersonNotFoundException(personId);
		}
		addressService.add(address,personId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/persons/{personId}/addresses/{id}")
	public void update(@RequestBody Address address, @PathVariable long id, @PathVariable long personId) {

		if(personService.getById(personId)==null) {
			throw new PersonNotFoundException(personId);
		}
		if(addressService.getById(id)== null) {
			throw new AddressNotFoundException(id);
		}
		addressService.update(address, id, personId);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/persons/{personId}/addresses")
	public void deleteByPersonId(@PathVariable long personId) {

		if(personService.getById(personId)==null) {
			throw new PersonNotFoundException(personId);
		}
		addressService.deleteByPersonId(personId);
	}

	@RequestMapping(method=RequestMethod.GET, value="/persons/{personId}/addresses")
	public List<Address> getByPersonId(@PathVariable long personId) {

		if(personService.getById(personId)==null) {
			throw new PersonNotFoundException(personId);
		}
		return addressService.getByPersonId(personId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/addresses/{id}")
	public void delete(@PathVariable long id) {
		if(addressService.getById(id)== null) {
			throw new AddressNotFoundException(id);
		}
		addressService.delete(id);
	}

	@RequestMapping(method=RequestMethod.GET, value="/addresses/{id}")
	public Address getById(@PathVariable long id) {
		Address address = addressService.getById(id);
		if(null == address) {
			throw new AddressNotFoundException(id);
		}
		return address;
	}
}
