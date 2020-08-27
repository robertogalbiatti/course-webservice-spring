package com.example.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.entities.Order;
import com.example.webservice.repositories.OrderRepository;

//registrando como componente (poderia ser o @Component, mas para semanticamente correto, utilizamos @Service por esta classe ser um Service)
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	// um método na camada de serviço em que ela repassa a chamada pro repository
	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();// retorna o Order dentro do Optional - Pq usar Optional? Ele só pega o
							// resultado se existir, invés de usarmos Exceção usamos ele.
	}
}
