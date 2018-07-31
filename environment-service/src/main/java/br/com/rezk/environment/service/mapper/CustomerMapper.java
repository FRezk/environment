package br.com.rezk.environment.service.mapper;

import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.request.CustomerRequest;

public class CustomerMapper {
	
	public Customer mapRequestToORM(CustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setLastName(request.getLastName());
		customer.setAge(request.getAge());
		return customer;
	}
	
	public CustomerRequest mapORMToResponse(Customer customer) {
		CustomerRequest response = new CustomerRequest();
		response.setId(customer.getId());
		response.setName(customer.getName());
		response.setLastName(customer.getLastName());
		response.setAge(customer.getAge());
		return response;
	}
	
}
