package br.com.rezk.environment.service.v1.home;

import br.com.rezk.environment.service.v1.HomeService;

public class HomeServiceProvider implements HomeService {

	public String helloWorld() {
		return "Hello World!";
	}

}
