package com.juansilva.workshopmongo3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juansilva.workshopmongo3.dominio.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	
	

}
