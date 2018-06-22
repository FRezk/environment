package br.com.rezk.environment.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import br.com.rezk.environment.service.v1.HomeService;
import br.com.rezk.environment.service.v1.home.HomeServiceProvider;

@Configuration
public class BeansConfig {
	
	//Here you config your service beans.
	//Basically, we configure beans from API layer, so we
	//can access using depencendy injection. Example:
	
	@Bean
	public HomeService homeService(){
		return new HomeServiceProvider();
	}
	
	@Bean
	public Gson gson(){
		return new Gson();
	}

}
