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

import com.accela.dao.AddressRepository;
import com.accela.model.Address;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {
	
	@Mock
	private AddressRepository addressRepositoryMock;
	
	@InjectMocks
	private AddressServiceImpl addressServiceImpl;

	@Test
	public void testAdd() {
		Address address = new Address();
		address.setId(1);
		address.setCity("xxx");
		address.setPostalCode("D15");
		long personId=1L;
		addressServiceImpl.add(address, personId);
		verify(addressRepositoryMock,times(1)).save(address);
	}

	@Test
	public void testUpdate() {
		Address address = new Address();
		address.setCity("xxx");
		address.setPostalCode("D15");
		long addressId=1L;
		long personId=2L;
		addressServiceImpl.update(address, addressId,personId);
		verify(addressRepositoryMock,times(1)).save(address);
	}

	@Test
	public void testDelete() {
		long addressId=1L;
		addressServiceImpl.delete(addressId);
		verify(addressRepositoryMock,times(1)).deleteById(addressId);
	}

	@Test
	public void testDeleteByPersonId() {
		long personId=1L;
		addressServiceImpl.deleteByPersonId(personId);
		verify(addressRepositoryMock,times(1)).deleteByPersonId(personId);
	}
	
	@Test
	public void testGetByPersonId() {
		long personId=1L;
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setId(1);
		address.setCity("xxx");
		address.setPostalCode("D15");
		addresses.add(address);
		when(addressRepositoryMock.findByPersonId(personId)).thenReturn(addresses);
		assertEquals(addresses,addressServiceImpl.getByPersonId(personId));
		verify(addressRepositoryMock,times(1)).findByPersonId(personId);
	}

	@Test
	public void testGetById() {
		long addressId=1L;
		Address address = new Address();
		address.setId(1);
		address.setCity("xxx");
		address.setPostalCode("D15");
		Optional<Address> optionalAddress = Optional.of(address);
		when(addressRepositoryMock.findById(addressId)).thenReturn(optionalAddress);
		assertEquals(address,addressServiceImpl.getById(addressId));
		verify(addressRepositoryMock,times(1)).findById(addressId);
	}
	
}
