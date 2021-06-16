package com.accela.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accela.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
}
