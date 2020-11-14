package com.timbuchalka.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	private final OrganizationDao organizationDao;

	@Autowired
	public OrganizationServiceImpl(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	public List<Organization> getOrgList() {

		List<Organization> orgList = organizationDao.getAllOrganizations();
		return orgList;
	}
}
