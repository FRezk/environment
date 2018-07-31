package br.com.rezk.environment.service.request;

import java.io.Serializable;

public class CustomerRequest implements Serializable{
	private static final long serialVersionUID = -5055633632600844846L;
	
	private Long id;
	private String name;
	private String lastName;
	private Long age;
	
	public CustomerRequest() {}
	
	public CustomerRequest(String name, String lastName, Long age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}

}