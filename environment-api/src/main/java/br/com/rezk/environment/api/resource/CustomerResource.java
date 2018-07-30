package br.com.rezk.environment.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.v1.CustomerService;
import br.com.rezk.environment.service.vo.CustomerVO;

@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Gson gson;
	
	@RequestMapping(method=RequestMethod.PUT, headers="Content-Type=application/json" , value="/customer", produces=MediaType.APPLICATION_JSON_VALUE)
	public String createCustomer(@RequestBody CustomerVO customverVO) {
		return customerService.createCustomer(customverVO);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public String readCustomer(@PathVariable Long id) {
		return gson.toJson(customerService.readCustomer(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, headers="Content-Type=application/json" , value="/customer")
	public HttpStatus updateCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.updateCustomer(customerRequest) ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, headers="Content-Type=application/json" , value="/customer")
	public HttpStatus deleteCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.deleteCustomer(customerRequest) ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND;
	}

}
