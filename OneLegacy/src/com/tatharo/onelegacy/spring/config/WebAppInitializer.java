package com.tatharo.onelegacy.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;  
  
public class WebAppInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {  
		
		
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(servletContext);
        DispatcherServlet dispatcherServlet =new DispatcherServlet(ctx);
        dispatcherServlet.setDetectAllHandlerMappings(true);
        dispatcherServlet.setDetectAllViewResolvers(true);
        
        Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);  
        dynamic.addMapping("/"); 
        dynamic.addMapping("/resources/**" ,"/WEB-INF/resources/");

        dynamic.setLoadOnStartup(1);  
   }
}