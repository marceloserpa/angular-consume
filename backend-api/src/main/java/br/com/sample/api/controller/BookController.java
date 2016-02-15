package br.com.sample.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<BookModel> getBooksName(){
		
		/**
		ArrayList<BookModel> list = new ArrayList<>();
		BookModel book1 = new BookModel();
		book1.setTitle("Title 1");
		book1.setDescription("Description 1");
		book1.setAuthor("Author 1");
		list.add(book1);
		
		BookModel book2 = new BookModel();
		book2.setTitle("Title 2");
		book2.setDescription("Description 2");
		book2.setAuthor("Author 2");
		list.add(book2);
		
		BookModel book3 = new BookModel();
		book3.setTitle("Title 3");
		book3.setDescription("Description 3");
		book3.setAuthor("Author 3");
		list.add(book3);
		*/
		return bookMapper.getAll();
	}
	
}
