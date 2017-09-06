package br.com.rezk.environment.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.rezk.environment.api.resource.HomeResource;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeResource.class})
public class AppWebConfig {
}
