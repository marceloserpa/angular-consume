package br.com.sample.api.service;

import br.com.sample.api.helper.JWTHelper;
import br.com.sample.api.model.AutenticationResponseModel;
import br.com.sample.api.model.UserModel;
import br.com.sample.api.persistence.UserMapper;

public class AutenticationService {

	private UserMapper userMapper;
	
	public AutenticationService(UserMapper userMapper){
		this.userMapper = userMapper;
	}
	
	public AutenticationResponseModel autenticate(UserModel user){
		String id = userMapper.autenticate(user);
		return new AutenticationResponseModel(new JWTHelper().build(id));
	}
	
}
