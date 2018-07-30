package br.com.rezk.environment.api.config;

import java.util.Random;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import com.google.gson.Gson;

import br.com.rezk.environment.service.dao.CustomerDAO;
import br.com.rezk.environment.service.database.DataBaseMock;
import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.v1.CustomerService;
import br.com.rezk.environment.service.v1.HomeService;
import br.com.rezk.environment.service.v1.provider.CustomerServiceProvider;
import br.com.rezk.environment.service.v1.provider.HomeServiceProvider;

@Configuration
public class BeansConfig {

	// Here you config your service beans.
	// Basically, we configure beans from API layer, so we
	// can access using depencendy injection. Example:

	@Bean
	public HomeService homeService() {
		return new HomeServiceProvider();
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}

	@Bean
	public CustomerService customerService() {
		return new CustomerServiceProvider();
	}

	@Bean
	public DataBaseMock database() {
		return new DataBaseMock();
	}

	@Bean
	public Random random() {
		return new Random();
	}
	
	@Bean
	public CustomerDAO customerDAO() {
		return new CustomerDAO();
	}

	@Bean
	@ApplicationScope
	public SessionFactory session() {
		// Create session factory
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).buildSessionFactory();
		return factory;
	}

}
