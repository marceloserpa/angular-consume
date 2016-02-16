package br.com.sample.api.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import br.com.sample.api.model.BookModel;

public interface BookMapper {

	@Select("select * from book")	
	public List<BookModel> getAll();
	
	@Insert("insert into book (title, description, author) values (#{title}, #{description}, #{author})")
	public void save(BookModel model);
	
}
