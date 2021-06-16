package com.accela.service;

import java.util.List;
import com.accela.model.Person;

public interface PersonService {

	public List<Person> getAll();
	
	public void add(Person person);
	
	public void update(Person person, long id);
	
	public void delete(long id);
	
	public long count();
	
	public Person getById(long id);
}
