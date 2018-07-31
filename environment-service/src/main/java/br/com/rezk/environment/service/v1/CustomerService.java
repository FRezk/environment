package br.com.rezk.environment.service.v1;

import java.util.List;

import br.com.rezk.environment.service.request.CustomerRequest;

public interface CustomerService {
	
	public CustomerRequest createCustomer(CustomerRequest customverVO);
	
	public CustomerRequest readCustomer(Long id);
	
	public CustomerRequest updateCustomer(CustomerRequest customerRequest, Long id);
	
	public Boolean deleteCustomer(CustomerRequest customerVO);
	
	public List<CustomerRequest> listCustomers();

}
