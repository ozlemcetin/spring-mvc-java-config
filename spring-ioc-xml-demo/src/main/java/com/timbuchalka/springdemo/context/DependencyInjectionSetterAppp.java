package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;

public class DependencyInjectionSetterAppp {

	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-def-in-classpath.xml");

		// create the bean
		Organization org = (Organization) ctx.getBean("myorg");

		// see the created bean
		System.out.println(org);

		// invoke the bean method
		String sloganStatic = org.staticCorporateSlogan();
		System.out.println(sloganStatic);

		String sloganProvided = org.provideCorporateSlogan();
		System.out.println(sloganProvided);

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
