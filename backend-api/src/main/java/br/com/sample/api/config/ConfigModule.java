package br.com.sample.api.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigModule {

	@Bean
	public FilterRegistrationBean filterRegistrationBean(AuthorizationFilter authorizationFilter){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.addUrlPatterns("/api/resources/*");
		filterRegistrationBean.setFilter(authorizationFilter);
		return filterRegistrationBean;
	}
	
	@Bean
	public AuthorizationFilter authorizationFilter(){
		return new AuthorizationFilter();
	}
	
	
}
