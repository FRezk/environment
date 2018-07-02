package br.com.rezk.environment.service.v1.provider;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.rezk.environment.service.database.DataBaseMock;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.v1.CustomerService;
import br.com.rezk.environment.service.vo.CustomerVO;

public class CustomerServiceProvider implements CustomerService {
	
	@Autowired
	DataBaseMock dataBaseMock;
	
	@Autowired
	private Gson gson = new Gson();
	
	@Autowired
	private Random random;

	public String createCustomer(CustomerVO customerVO) {
		dataBaseMock.getCustomerTableMock().put(random.nextInt(100 - 5) + 5, customerVO);
		return gson.toJson(dataBaseMock.getCustomerTableMock());
	}

	public String readCustomer() {
		return gson.toJson(dataBaseMock.getCustomerTableMock());
	}

	public Boolean updateCustomer(CustomerRequest customerRequest) {
		CustomerVO stagedCustomer = dataBaseMock.getCustomerTableMock().get(customerRequest.getId());
		if(stagedCustomer != null) {
			CustomerVO vo = customerRequest.getCustomer();
			stagedCustomer.setAge(vo.getAge());
			stagedCustomer.setName(vo.getName());
			return true;
		}
		return false;
	}

	public Boolean deleteCustomer(CustomerRequest customerRequest) {
		if (dataBaseMock.getCustomerTableMock().remove(customerRequest.getId()) != null) {
			return true;
		}
		return false;
	}

}
