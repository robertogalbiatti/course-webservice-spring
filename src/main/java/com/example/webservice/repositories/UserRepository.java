package com.example.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//esta interface já tem uma implementação padrão, não precisamos implementar nada aqui

}
