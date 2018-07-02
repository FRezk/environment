package br.com.rezk.environment.service.request;

import java.io.Serializable;

import br.com.rezk.environment.service.vo.CustomerVO;

public class CustomerRequest implements Serializable{

	private static final long serialVersionUID = -5641635891967430062L;
	
	private Integer id;
	private CustomerVO customer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO vo) {
		this.customer = vo;
	}
	
	
	

}
