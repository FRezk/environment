package br.com.rezk.environment.service.v1.provider;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rezk.environment.service.dao.CustomerDAO;
import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.mapper.CustomerMapper;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.response.CustomerResponse;
import br.com.rezk.environment.service.v1.CustomerService;

public class CustomerServiceProvider implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerMapper customerMapper;

	public CustomerResponse createCustomer(CustomerRequest request) {
		Customer customer = customerMapper.mapRequestToORM(request);
		customerDAO.insert(customer);
		return customerMapper.mapORMToResponse(customer);
	}

	public Customer readCustomer(Long id) {
		return customerDAO.find(id);
	}

	public Customer updateCustomer(CustomerRequest customerRequest, Long id) {
		Customer customer = customerDAO.find(id);
		customer.setName(customerRequest.getName());
		customer.setLastName(customerRequest.getLastName());
		customer.setAge(customerRequest.getAge());
		
		return customerDAO.merge(customer);
	}

	public Boolean deleteCustomer(CustomerRequest customerRequest) {
		//if (dataBaseMock.getCustomerTableMock().remove(customerRequest.getId()) != null) {
		//	return true;
		//}
		return false;
	}

}
