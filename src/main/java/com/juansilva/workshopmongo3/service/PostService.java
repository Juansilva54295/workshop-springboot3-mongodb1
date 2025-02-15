package com.juansilva.workshopmongo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juansilva.workshopmongo3.dominio.Post;
import com.juansilva.workshopmongo3.repository.PostRepository;
import com.juansilva.workshopmongo3.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	
	public Post findById(String id) {
		return repo.findById(id)
			.orElseThrow(() -> new ObjectNotFoundException("OBJETO NÃO ENCONTRADO"));
	}
	
	public List<Post> findByTitle(String text){
		return  repo.findByTitleContainingIgnoreCase(text);
	}

}
