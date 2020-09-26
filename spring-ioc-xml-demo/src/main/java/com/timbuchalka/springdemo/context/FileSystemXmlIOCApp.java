package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.timbuchalka.springdemo.domain.City;

public class FileSystemXmlIOCApp {

	public static void main(String[] args) {

		/*
		 * create the application context (container)
		 * "src/main/resources/spring-bean-def-in-classpath.xml"
		 */
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-bean-def-under-projectfolder.xml");

		// create the bean
		City city = (City) ctx.getBean("mycity");

		// invoke the bean method
		city.cityName();

		// close the application context
		((FileSystemXmlApplicationContext) ctx).close();

	}

}
