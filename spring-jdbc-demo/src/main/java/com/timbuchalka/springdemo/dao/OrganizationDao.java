package com.timbuchalka.springdemo.dao;

import java.util.List;

import com.timbuchalka.springdemo.domain.Organization;

public interface OrganizationDao {

	// Create a record in the organization table
	public boolean create(Organization org);

	// Retrieve a single organization
	public Organization getOrganization(Integer id);

	// Retrieve all organizations from the table.
	public List<Organization> getAllOrganizations();

	// Delete a specific organization from the table.
	public boolean delete(Organization org);

	// Update an existing organization
	public boolean update(Organization org);

	public void cleanup();

}
