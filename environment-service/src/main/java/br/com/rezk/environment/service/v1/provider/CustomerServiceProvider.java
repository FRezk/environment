package br.com.rezk.environment.service.v1.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.rezk.environment.service.dao.CustomerDAO;
import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.mapper.CustomerMapper;
import br.com.rezk.environment.service.mapper.ObjMapper;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.v1.CustomerService;

public class CustomerServiceProvider implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	@Qualifier("customerToRequest")
	private ObjMapper customerToRequest;
	

	public CustomerRequest createCustomer(CustomerRequest request) {
		Customer customer = customerMapper.mapRequestToORM(request);
		customerDAO.persist(customer);
		
		return customerMapper.mapORMToResponse(customer);
	}

	public CustomerRequest readCustomer(Long id) {
		Customer customer = customerDAO.find(id);
		
		return customerMapper.mapORMToResponse(customer);
	}

	public CustomerRequest updateCustomer(CustomerRequest customerRequest, Long id) {
		Customer customer = customerDAO.find(id);
		customer.setName(customerRequest.getName());
		customer.setLastName(customerRequest.getLastName());
		customer.setAge(customerRequest.getAge());
		customerDAO.merge(customer);
		
		return customerMapper.mapORMToResponse(customer);
	}

	public Boolean deleteCustomer(CustomerRequest customerRequest) {
		Customer customer = customerMapper.mapRequestToORM(customerRequest);
		try {
			customerDAO.delete(customer);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public List<CustomerRequest> listCustomers(){
		List<Customer> customers = customerDAO.list();
		
		List<CustomerRequest> result = customers.stream().map(temp -> {
			return (CustomerRequest) customerToRequest.map(temp);
		}).collect(Collectors.toList());
		
		return result;
	}
}
