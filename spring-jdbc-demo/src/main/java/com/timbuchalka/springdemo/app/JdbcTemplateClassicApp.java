package com.timbuchalka.springdemo.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.daoimpl.OrganizationDaoImpl;
import com.timbuchalka.springdemo.domain.Organization;

public class JdbcTemplateClassicApp {

	public static void main(String[] args) {

		// creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("organizationDaoImpl");

		// get all organizations
		List<Organization> list = dao.getAllOrganizations();

		for (Organization org : list) {
			System.out.println(org);
		}

		// close the application context

		((ClassPathXmlApplicationContext) ctx).close();
	}

}
