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

import com.accela.service.PersonService;
import com.accela.exceptions.PersonNotFoundException;
import com.accela.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Person person) {
		personService.add(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void update(@RequestBody Person person, @PathVariable long id) {
		if(personService.getById(id)== null) {
			throw new PersonNotFoundException(id);
		}
		personService.update(person, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete(@PathVariable long id) {
		if(personService.getById(id)== null) {
			throw new PersonNotFoundException(id);
		}
		personService.delete(id);
	}

	@RequestMapping(method=RequestMethod.GET, value="/count")
	public long count() {
		return personService.count();
		
	}

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Person getById(@PathVariable long id) {
		Person person = personService.getById(id);
		if(null == person) {
			throw new PersonNotFoundException(id);
		}
		return person;
	}

}
