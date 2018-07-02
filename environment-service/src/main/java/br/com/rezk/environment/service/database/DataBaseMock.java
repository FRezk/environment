package br.com.rezk.environment.service.database;

import java.util.HashMap;

import br.com.rezk.environment.service.vo.CustomerVO;

public class DataBaseMock {
	
	private HashMap<Integer, CustomerVO> customerTableMock;
		
	public DataBaseMock() {
		if (this.customerTableMock == null || this.customerTableMock.isEmpty()) {
			this.customerTableMock = new HashMap<Integer, CustomerVO>();
			this.customerTableMock.put(1,(new CustomerVO("Fernando D. Rezk", 23)));
			this.customerTableMock.put(2,(new CustomerVO("Fernando Denarelli", 23)));
			this.customerTableMock.put(3,(new CustomerVO("Fernando Rezk", 23)));
		}
	}

	public HashMap<Integer, CustomerVO> getCustomerTableMock() {
		return customerTableMock;
	}
	
}
