package br.com.rezk.environment.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rezk.environment.service.v1.HomeService;

@RestController
public class HomeResource {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/hello")
	public String helloWorld(){
		return homeService.helloWorld();
	}

}
