package br.com.sample.api.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.sample.api.Application;
import br.com.sample.api.helper.JWTHelper;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class AutenticationControllerTest {

    @Autowired private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }	
	
	@Test
	public void shouldReturnTokenTest() throws Exception{		
		MvcResult result = this.mockMvc.perform(
				post("/api/autentication/oauth/token")
					.param("username", "admin")
					.param("password", "admin")
				).andReturn();
	    String token = getTokenByResponseContent(result.getResponse().getContentAsString());
	    assertEquals("1", new JWTHelper().parse(token).getSubject());
	}
	
	private String getTokenByResponseContent(String responseContent){
		String replace = responseContent.replace("\"", "");
		String[] pieces = replace.split("(:)|(,)");
		return pieces[1];
	}
	
}
