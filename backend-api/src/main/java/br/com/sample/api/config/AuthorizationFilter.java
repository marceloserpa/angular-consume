package br.com.sample.api.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sample.api.service.AutenticationService;

@Component
public class AuthorizationFilter implements Filter {
 
	@Autowired AutenticationService autenticationService;
	
    @Override
    public void init(FilterConfig arg0) throws ServletException {}
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest= (HttpServletRequest) request;
        
        
        String token = httpRequest.getHeader("authorization-token");
        System.out.println("========");
        if(token != null){
        	String[] tokenSplited = token.split(" ");
        	if(tokenSplited[0] == null || !tokenSplited[0].equals("Bearer")){
        		new RuntimeException("Bearer token not found");
        	}
        	
        	if(!autenticationService.exists(tokenSplited[1])){
        		new RuntimeException("User not exists");
        	}
        	
        }
        System.out.println("========");
        
        

        chain.doFilter(request, response);
    }
 
    @Override
    public void destroy() {}
 
}
