package br.com.rezk.environment.service.v1;

import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.response.CustomerResponse;

public interface CustomerService {
	
	public CustomerResponse createCustomer(CustomerRequest customverVO);
	
	public Customer readCustomer(Long id);
	
	public Customer updateCustomer(CustomerRequest customerRequest, Long id);
	
	public Boolean deleteCustomer(CustomerRequest customerVO);

}
