package com.juansilva.workshopmongo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juansilva.workshopmongo3.dominio.User;
import com.juansilva.workshopmongo3.repository.UserRepository;
import com.juansilva.workshopmongo3.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		// Usando findById, que retorna um Optional
		return repo.findById(id)
			.orElseThrow(() -> new ObjectNotFoundException("OBJETO NÃO ENCONTRADO"));
	}
}
