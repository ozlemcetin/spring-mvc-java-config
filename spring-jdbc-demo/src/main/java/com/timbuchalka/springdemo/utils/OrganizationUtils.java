package com.timbuchalka.springdemo.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Component
public class OrganizationUtils {

	public void printOrganizations(List<Organization> orgs, String operation) {

		System.out.println("\n********* printing organizations after " + operation + " operation *********");
		for (Organization org : orgs) {
			System.out.println(org);
		}
	}

	public void printOrganization(Organization org, String operation) {
		System.out.println("\n**********Printing organization after invoking " + operation + " *********\n" + org);
	}

	public void createSeedData(OrganizationDao dao) {

		Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
		Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");
		Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");

		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0, org1);
		orgs.add(1, org2);
		orgs.add(2, org3);

		int createCount = 0;
		for (Organization org : orgs) {

			boolean isCreated = dao.create(org);
			if (isCreated)
				createCount += 1;
		}

		System.out.println("Created " + createCount + " organizations");
	}

	public void printOrganizationCount(List<Organization> orgs, String operation) {

		System.out.println("\n*********Currently we have " + orgs.size() + " organizations after " + operation
				+ " operation" + "   *********");

	}
}
