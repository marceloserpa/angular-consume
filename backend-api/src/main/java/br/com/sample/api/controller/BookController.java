package br.com.sample.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.api.model.BookModel;
import br.com.sample.api.persistence.BookMapper;
import br.com.sample.api.service.BookService;

@RestController
@RequestMapping(value="api/books")
public class BookController {
	
	@Autowired private BookService bookService;

	@RequestMapping(method=RequestMethod.GET)
	public List<BookModel> list(){
		return bookService.get();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Long create(@RequestBody BookModel book){
		return bookService.save(book);
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete(@PathVariable Long id){
		bookService.delete(id);
	}	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void edit(@PathVariable Long id, @RequestBody BookModel book){
		bookService.update(id, book);
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public BookModel findById(@PathVariable Long id){
		return bookService.getOne(id);
	}
	
}
