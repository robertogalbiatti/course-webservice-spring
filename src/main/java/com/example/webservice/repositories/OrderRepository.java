package com.example.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	//esta interface já tem uma implementação padrão, não precisamos implementar nada aqui

}
