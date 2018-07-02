package br.com.rezk.environment.service.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable{
	private static final long serialVersionUID = -5055633632600844846L;
	
	private String name;
	private Integer age;
	
	public CustomerVO() {}
	
	public CustomerVO(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
