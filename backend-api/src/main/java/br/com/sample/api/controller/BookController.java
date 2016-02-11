package br.com.sample.api.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@RequestMapping(method=RequestMethod.GET, value="api/books")
	public ArrayList<String> getBooksName(){
		ArrayList<String> list = new ArrayList<>();
		list.add("Book A");
		list.add("Book B");
		list.add("Book C");
		return list;
	}
	
}
