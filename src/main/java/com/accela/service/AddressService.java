package com.accela.service;

import java.util.List;

import com.accela.model.Address;

public interface AddressService {
	
	public void add(Address address,long personId);
	
	public void update(Address address, long id,long personId);
	
	public void delete(long id);
	
	public void deleteByPersonId(long personId);
	
	public List<Address> getByPersonId(long personId);
	
	public Address getById(long id);
}
