package com.timbuchalka.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

//@Repository("organizationDaoJdbcImpl")
public class OrganizationDaoJdbcImpl implements OrganizationDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public OrganizationDaoJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Organization getOrganization(Integer id) {

		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan"
				+ " FROM organization WHERE id = ?";

		Object[] args = new Object[] { id };

		// queryForObject
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {

		String sqlQuery = "SELECT * FROM organization";

		// query
		List<Organization> list = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return list;
	}

	public boolean create(Organization org) {

		String sqlQuery = "INSERT INTO organization "
				+ "(company_name, year_of_incorporation, postal_code, employee_count, slogan) "
				+ "VALUES(?, ?, ?, ?, ?)";

		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
				org.getEmployeeCount(), org.getSlogan() };

		// update
		int numberOfRecordsAffected = jdbcTemplate.update(sqlQuery, args);
		return numberOfRecordsAffected == 1;
	}

	public boolean delete(Organization org) {

		String sqlQuery = "DELE FROM  organization WHERE id = ?";

		Object[] args = new Object[] { org.getId() };

		// update
		int numberOfRecordsAffected = jdbcTemplate.update(sqlQuery, args);
		return numberOfRecordsAffected == 1;
	}

	public boolean update(Organization org) {

		String sqlQuery = "UPDATE  organization set slogan = ? WHERE id = ?";

		Object[] args = new Object[] { org.getSlogan(), org.getId() };

		// update
		int numberOfRecordsAffected = jdbcTemplate.update(sqlQuery, args);
		return numberOfRecordsAffected == 1;

	}

	public void cleanup() {

		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);
	}

}
