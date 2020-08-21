package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.entities.User;
import com.example.webservice.repositories.UserRepository;


//registrando como componente (poderia ser o @Component, mas para semanticamente correto, utilizamos @Service por esta classe ser um Service)
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//um método na camada de serviço em que ela repassa a chamada pro repository
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();//retorna o User dentro do Optional - Pq usar Optional? Ele só pega o resultado se existir, invés de usarmos Exceção usamos ele.
	}
}
