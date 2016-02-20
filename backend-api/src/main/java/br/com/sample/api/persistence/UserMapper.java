package br.com.sample.api.persistence;

import org.apache.ibatis.annotations.Select;

import br.com.sample.api.model.UserModel;

public interface UserMapper {

	@Select("select id from users where username = #{username} and password = #{password}")
	public String autenticate(UserModel user);
	
}
