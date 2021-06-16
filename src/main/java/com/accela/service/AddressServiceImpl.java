package com.accela.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accela.dao.AddressRepository;
import com.accela.model.Address;
import com.accela.model.Person;


@Service
@Transactional
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void add(Address address,long personId) {
		Person person = new Person();
		person.setId(personId);
		address.setPerson(person);
		addressRepository.save(address);
	}

	@Override
	public void update(Address address, long id,long personId) {
		Person person = new Person();
		person.setId(personId);
		address.setId(id);
		address.setPerson(person);
		addressRepository.save(address);
		
	}

	@Override
	public void delete(long id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Address getById(long id) {
		Optional<Address> address = addressRepository.findById(id);
		if(address.isPresent()) {
			return address.get();
		}
		return null;
	}

	@Override
	public void deleteByPersonId(long personId) {
		addressRepository.deleteByPersonId(personId);
		
	}

	@Override
	public List<Address> getByPersonId(long personId) {
		return addressRepository.findByPersonId(personId);
	}


}
