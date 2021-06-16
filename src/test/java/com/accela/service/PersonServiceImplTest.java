package com.accela.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accela.dao.PersonRepository;
import com.accela.model.Person;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

	@Mock
	private PersonRepository personRepositoryMock;
	
	@InjectMocks
	private PersonServiceImpl personServiceImpl;

	@Test
	public void testgetAll() {
		Person person1 = new Person();
		person1.setId(0);
		person1.setFirstName("abcd");
		person1.setLastName("efgh");
		List<Person> persons = new ArrayList<>();
		persons.add(person1);	
		when(personRepositoryMock.findAll()).thenReturn(persons);
		assertEquals(persons,personServiceImpl.getAll());
		verify(personRepositoryMock,times(1)).findAll();
	}

	@Test
	public void testAdd() {
		Person person = new Person();
		person.setId(0);
		person.setFirstName("abcd");
		person.setLastName("efgh");
		personServiceImpl.add(person);
		verify(personRepositoryMock,times(1)).save(person);
	}

	@Test
	public void testUpdate() {
		Person person = new Person();
		person.setId(0);
		person.setFirstName("abcd");
		person.setLastName("efgh");
		long personId=1L;
		personServiceImpl.update(person, personId);
		verify(personRepositoryMock,times(1)).save(person);
	}

	@Test
	public void testDelete() {
		long personId=1L;
		personServiceImpl.delete(personId);
		verify(personRepositoryMock,times(1)).deleteById(personId);
	}

	@Test
	public void testCount() {
		long count = 10;
		when(personRepositoryMock.count()).thenReturn(count);
		assertEquals(count,personServiceImpl.count());
		verify(personRepositoryMock,times(1)).count();
	}

	@Test
	public void testGetById() {
		long personId=1L;
		Person person = new Person();
		person.setId(0);
		person.setFirstName("abcd");
		person.setLastName("efgh");
		Optional<Person> optionalPerson = Optional.of(person);
		when(personRepositoryMock.findById(personId)).thenReturn(optionalPerson);
		assertEquals(person,personServiceImpl.getById(personId));
		verify(personRepositoryMock,times(1)).findById(personId);
	}
}
