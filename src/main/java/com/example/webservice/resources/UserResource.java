package com.example.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.entities.User;
import com.example.webservice.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//ReponseEntity é um tipo de retorno do Spring pra retornar respostas de requisições WEB
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint para buscar usuário por ID
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){ //usamos PathVariable pro Spring considerar este parâmetro no id
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
