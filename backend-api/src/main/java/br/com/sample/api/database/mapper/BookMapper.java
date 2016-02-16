package br.com.sample.api.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import br.com.sample.api.model.BookModel;

public interface BookMapper {

	@Select("select * from book")	
	public List<BookModel> getAll();
	
	@Insert("insert into book (title, description, author) values (#{title}, #{description}, #{author})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	public Long save(BookModel model);
	
	@Select("delete from book where id = #{id}")	
	public List<BookModel> delete(Long id);	
	
}