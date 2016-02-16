package br.com.sample.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.api.database.mapper.BookMapper;
import br.com.sample.api.model.BookModel;

@RestController
public class BookController {
	
	@Autowired
	private BookMapper bookMapper;

	@RequestMapping(method=RequestMethod.GET, value="api/books")
	public List<BookModel> get(){
		return bookMapper.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="api/books")
	public Long save(@RequestBody BookModel book){
		return bookMapper.save(book);
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, value="api/books/{id}")
	public void delete(@PathVariable Long id){
		bookMapper.delete(id);
	}	
	
	@RequestMapping(method=RequestMethod.PUT, value="api/books/{id}")
	public void update(@PathVariable Long id, @RequestBody BookModel book){
		book.setId(id);
		bookMapper.update(book);
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="api/books/{id}")
	public BookModel getOne(@PathVariable Long id){
		return bookMapper.getOne(id);
	}
	
}
