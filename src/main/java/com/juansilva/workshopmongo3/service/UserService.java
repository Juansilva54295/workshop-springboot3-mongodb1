package com.juansilva.workshopmongo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juansilva.workshopmongo3.dominio.User;
import com.juansilva.workshopmongo3.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
	    findById(id);  
	    repo.deleteById(id);  
	}

	public User update(User obj) {
	    User newObj = repo.findById(obj.getId())
	            .orElseThrow(() -> new ObjectNotFoundException("OBJETO NÃO ENCONTRADO"));
	    
	    updateData(newObj, obj);  
	    return repo.save(newObj); 
	}

	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
