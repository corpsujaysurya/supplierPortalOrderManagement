package com.kpmg.te.retail.supplierportal.OrderManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@SpringBootApplication(scanBasePackages = { "com.kpmg.te.retail.supplierportal.OrderManagement" },exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({ "com.kpmg.te.retail.supplierportal.OrderManagement" })
@EnableWebMvc
@EnableJpaRepositories
public class SupplierPortalOrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierPortalOrderManagementApplication.class, args);
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SupplierPortalOrderManagementApplication.class);
	}

}
