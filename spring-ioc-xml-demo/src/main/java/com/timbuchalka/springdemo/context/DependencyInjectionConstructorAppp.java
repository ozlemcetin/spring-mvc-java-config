package com.timbuchalka.springdemo.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.HumanResourceDept;

public class DependencyInjectionConstructorAppp {

	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean-def-in-classpath.xml");

		// create the bean
		HumanResourceDept hrdept = (HumanResourceDept) ctx.getBean("myhrdept");

		// see the created bean
		System.out.println(hrdept);

		// invoke the bean method
		System.out.println(hrdept.hiring(35));

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
