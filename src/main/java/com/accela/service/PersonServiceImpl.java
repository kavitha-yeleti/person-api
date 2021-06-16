package com.accela.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accela.dao.PersonRepository;
import com.accela.model.Person;


@Service
@Transactional
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public void add(Person person) {
		personRepository.save(person);
	}

	@Override
	public void update(Person person, long id) {
		person.setId(id);
		personRepository.save(person);
	}

	@Override
	public void delete(long id) {
		personRepository.deleteById(id);
		
	}

	@Override
	public long count() {
		return personRepository.count();
	}

	@Override
	public Person getById(long id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
			return person.get();
		}
		return null;
	}

}
