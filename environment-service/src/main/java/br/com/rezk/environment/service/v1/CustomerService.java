package br.com.rezk.environment.service.v1;

import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.vo.CustomerVO;

public interface CustomerService {
	
	public String createCustomer(CustomerVO customverVO);
	
	public Customer readCustomer(Long id);
	
	public Boolean updateCustomer(CustomerRequest customerRequest);
	
	public Boolean deleteCustomer(CustomerRequest customerVO);

}
