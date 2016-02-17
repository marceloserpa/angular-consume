package br.com.sample.api.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sample.api.persistence.BookMapper;

@Configuration
public class ServiceModule {

	@Bean
	public BookService bookService(BookMapper bookMapper){
		return new BookService(bookMapper);		
	}
	
}
