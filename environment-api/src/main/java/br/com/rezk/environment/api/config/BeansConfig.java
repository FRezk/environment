package br.com.rezk.environment.api.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import br.com.rezk.environment.service.database.DataBaseMock;
import br.com.rezk.environment.service.v1.CustomerService;
import br.com.rezk.environment.service.v1.HomeService;
import br.com.rezk.environment.service.v1.provider.CustomerServiceProvider;
import br.com.rezk.environment.service.v1.provider.HomeServiceProvider;

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
	
	@Bean
	public CustomerService customerService() {
		return new CustomerServiceProvider();
	}
	
	@Bean
	public DataBaseMock	database() {
		return new DataBaseMock();
	}
	
	@Bean
	public Random random() {
		return new Random();
	}

}
