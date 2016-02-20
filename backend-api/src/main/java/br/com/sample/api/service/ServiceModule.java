package br.com.sample.api.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sample.api.persistence.BookMapper;
import br.com.sample.api.persistence.UserMapper;

@Configuration
public class ServiceModule {

	@Bean
	public BookService bookService(BookMapper bookMapper){
		return new BookService(bookMapper);		
	}
	
	@Bean
	public AutenticationService autenticationService(UserMapper userMapper){
		return new AutenticationService(userMapper);
	}
	
}
