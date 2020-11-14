package com.timbuchalka.springdemo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;
import com.timbuchalka.springdemo.utils.DaoUtils;
import com.timbuchalka.springdemo.utils.OrganizationUtils;

@Component
public class NamedJdbcTemplateApp {

	private final OrganizationDao dao;
	private final OrganizationUtils organizationUtils;
	private final DaoUtils daoUtils;

	@Autowired
	public NamedJdbcTemplateApp(OrganizationDao dao, OrganizationUtils organizationUtils, DaoUtils daoUtils) {
		this.dao = dao;
		this.organizationUtils = organizationUtils;
		this.daoUtils = daoUtils;
	}

	public static void main(String[] args) {

		// creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the bean
		NamedJdbcTemplateApp mainApp = ctx.getBean(NamedJdbcTemplateApp.class);

		// main action
		mainApp.mainAction();

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();

	}

	public void mainAction() {

		// creating seed data
		organizationUtils.createSeedData(dao);
		organizationUtils.printOrganizations(dao.getAllOrganizations(), "getAllOrganizations");

		// Create a new organization record
		{

			Organization orgNew = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
			boolean isCreated = dao.create(orgNew);
			daoUtils.printSuccessFailure(daoUtils.CREATE, isCreated);

		}

		organizationUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.CREATE);

		// get a single organization
		Organization orgById1 = dao.getOrganization(1);
		organizationUtils.printOrganization(orgById1, "getOrganization");

		// Updating a slogan for an organization
		{
			orgById1.setSlogan("We build ** awesome ** driving machines!");
			boolean isUpdated = dao.update(orgById1);
			daoUtils.printSuccessFailure(daoUtils.UPDATE, isUpdated);
		}

		organizationUtils.printOrganization(dao.getOrganization(1), daoUtils.UPDATE);

		// Delete an organization
		{

			boolean isDeleted = dao.delete(dao.getOrganization(1));
			daoUtils.printSuccessFailure(daoUtils.DELETE, isDeleted);

		}

		organizationUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.DELETE);

		// Cleanup
		dao.cleanup();
		organizationUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.TRUNCATE);

	}

}
