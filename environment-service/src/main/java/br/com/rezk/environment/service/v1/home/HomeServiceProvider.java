package br.com.rezk.environment.service.v1.home;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.rezk.environment.service.v1.HomeService;
import br.com.rezk.environment.service.vo.SampleVO;

public class HomeServiceProvider implements HomeService {
	
	@Autowired
	Gson gson = new Gson();

	public String helloWorld() {
		SampleVO vo = new SampleVO();
		return gson.toJson(vo);
	}

}
