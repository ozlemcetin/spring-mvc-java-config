package com.timbuchalka.springdemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.timbuchalka.springdemo")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setUseSuffixPatternMatch(false);
		handlerMapping.setUseTrailingSlashMatch(false);
		return handlerMapping;
	}

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {

		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public DataSource dataSource() {

		/*
		 * Tomcat >> context. xml
		 * 
		 * <Resource name="jdbc/springdb" auth="Container" type="javax.sql.DataSource"
		 * maxTotal="100" maxIdle="30" maxWaitMillis="10000" username="devuser"
		 * password="devuser" driverClassName="com.mysql.cj.jdbc.Driver"
		 * url="jdbc:mysql://localhost:3306/spring_db?useSSL=false" />
		 * 
		 */

		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);

		// java:comp/env/jdbc/springdb
		return dsLookup.getDataSource("jdbc/springdb");

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");

	}

}
