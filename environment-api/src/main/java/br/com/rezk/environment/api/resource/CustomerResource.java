package br.com.rezk.environment.api.resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rezk.environment.service.vo.CustomerVO;

@RestController
public class CustomerResource {
	
	@RequestMapping(method=RequestMethod.POST, headers="Content-Type=application/json" , value="/customer")
	public String tryy(@RequestBody CustomerVO a) {
		System.out.println(a.getName());
		System.out.println(a.getAge());
		return "";
	}

}
