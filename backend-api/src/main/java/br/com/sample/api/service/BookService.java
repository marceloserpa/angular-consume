package br.com.sample.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sample.api.model.BookModel;
import br.com.sample.api.persistence.BookMapper;

public class BookService {

	private BookMapper bookMapper;

	public BookService(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public List<BookModel> get(){
		return bookMapper.getAll();
	}
	
	public Long save(BookModel book){
		return bookMapper.save(book);
	}	
	
	public void delete(Long id){
		bookMapper.delete(id);
	}	
	
	public void update(Long id, BookModel book){
		book.setId(id);
		bookMapper.update(book);
	}	
	
	public BookModel getOne(Long id){
		return bookMapper.getOne(id);
	}
	
}
