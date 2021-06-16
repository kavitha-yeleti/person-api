package com.accela.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accela.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
   public void deleteByPersonId(long personId);
   public List<Address> findByPersonId(long personId);
}
