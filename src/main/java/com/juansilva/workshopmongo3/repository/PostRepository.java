package com.juansilva.workshopmongo3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juansilva.workshopmongo3.dominio.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	

}
