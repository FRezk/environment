package br.com.rezk.environment.service.mapper;

import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.response.CustomerResponse;

public class CustomerMapper {
	
	public Customer mapRequestToORM(CustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setLastName(request.getLastName());
		customer.setAge(request.getAge());
		return customer;
	}
	
	public CustomerResponse mapORMToResponse(Customer customer) {
		CustomerResponse response = new CustomerResponse();
		response.setId(customer.getId());
		response.setName(customer.getName());
		response.setLastName(customer.getLastName());
		return response;
	}
	
}
