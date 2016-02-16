package br.com.sample.api.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import br.com.sample.api.model.BookModel;

public interface BookMapper {

	@Select("select * from book")	
	public List<BookModel> getAll();
	
	@Insert("insert into book (title, description, author) values (#{title}, #{description}, #{author})")
	@Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
	public Long save(BookModel model);
	
	@Select("delete from book where id = #{id}")	
	public List<BookModel> delete(Long id);	
	
	@Update("update book set title=#{title}, description=#{description}, author=#{author} where id=#{id}")
	public void update(BookModel book);
	
	@Select("select * from book where id = #{id}")	
	public BookModel getOne(Long id);
}
