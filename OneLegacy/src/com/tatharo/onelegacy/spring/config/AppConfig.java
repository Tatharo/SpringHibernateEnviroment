package com.tatharo.onelegacy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan("com.tatharo.onelegacy")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
	@Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/*.html").addResourceLocations("/WEB-INF/resources/").setCachePeriod(31556926);
	  }
	@Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	  }
//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
//	final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//    final ObjectMapper objectMapper = new ObjectMapper();
//    converter.setObjectMapper(objectMapper);
//    super.add;
//	}

}
