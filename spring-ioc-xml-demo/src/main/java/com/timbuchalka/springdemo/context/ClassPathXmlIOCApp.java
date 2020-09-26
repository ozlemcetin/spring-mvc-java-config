package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;

public class ClassPathXmlIOCApp {

	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-def-in-classpath.xml");

		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");

		// see the created bean
		System.out.println(org);

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
