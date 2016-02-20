package br.com.sample.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.api.model.AutenticationResponseModel;
import br.com.sample.api.model.UserModel;
import br.com.sample.api.service.AutenticationService;

@RestController
@RequestMapping(value="api/autentication")
public class AutenticationController {

	@Autowired private AutenticationService autenticationService;

	@RequestMapping(method=RequestMethod.POST, value="/oauth/token")
	public AutenticationResponseModel autenticate(UserModel user){
		return autenticationService.autenticate(user);
	}
	
}
