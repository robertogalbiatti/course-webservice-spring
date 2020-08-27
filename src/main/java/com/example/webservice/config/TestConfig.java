package com.example.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webservice.entities.Order;
import com.example.webservice.entities.User;
import com.example.webservice.repositories.OrderRepository;
import com.example.webservice.repositories.UserRepository;

@Configuration
@Profile("test") // este 'test' bate com o 'teste' escrito no spring.profile.active=test no
					// Application properties de teste

//executar pra quando o programa for executado
public class TestConfig implements CommandLineRunner{

	// injeção de dependência automática do framework, instanciação automática.
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	
	//----------Instanciando o banco de dados-------------
	@Override //veio do CommandLineRunner, tudo aqui dentro executa quando iniciar o programa
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); //famosa associação de objetos, passando o User (u1)
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
