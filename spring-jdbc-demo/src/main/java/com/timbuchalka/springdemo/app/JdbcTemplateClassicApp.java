package com.timbuchalka.springdemo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.daoimpl.OrganizationDaoImpl;
import com.timbuchalka.springdemo.domain.Organization;
import com.timbuchalka.springdemo.utils.DaoUtils;
import com.timbuchalka.springdemo.utils.OrganizationUtils;

public class JdbcTemplateClassicApp {

	public static void main(String[] args) {

		// creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("organizationDaoImpl");

		{
			// creating seed data
			OrganizationUtils.createSeedData(dao);
			OrganizationUtils.printOrganizations(dao.getAllOrganizations(), "getAllOrganizations");

			// Create a new organization record
			{
				Organization orgNew = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
				boolean isCreated = dao.create(orgNew);
				DaoUtils.printSuccessFailure(DaoUtils.CREATE, isCreated);
			}

			OrganizationUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.CREATE);

			// get a single organization
			Organization orgById1 = dao.getOrganization(1);
			OrganizationUtils.printOrganization(orgById1, "getOrganization");

			// Updating a slogan for an organization
			{
				orgById1.setSlogan("We build ** awesome ** driving machines!");
				boolean isUpdated = dao.update(orgById1);
				DaoUtils.printSuccessFailure(DaoUtils.UPDATE, isUpdated);
			}

			OrganizationUtils.printOrganization(dao.getOrganization(1), DaoUtils.UPDATE);

			// Delete an organization
			{
				boolean isDeleted = dao.delete(dao.getOrganization(1));
				DaoUtils.printSuccessFailure(DaoUtils.DELETE, isDeleted);
			}

			OrganizationUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.DELETE);

			// Cleanup
			dao.cleanup();
			OrganizationUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.TRUNCATE);
		}

		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
