package com.timbuchalka.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Repository
public class OrganizationDaoNamedParameterImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public OrganizationDaoNamedParameterImpl(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public Organization getOrganization(Integer id) {

		SqlParameterSource parameterSource = new MapSqlParameterSource("ID", id);

		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan"
				+ " FROM organization WHERE id = :ID ";

		// queryForObject
		Organization org = namedParameterJdbcTemplate.queryForObject(sqlQuery, parameterSource,
				new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {

		String sqlQuery = "SELECT * FROM organization";

		// query
		List<Organization> list = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return list;
	}

	public boolean create(Organization org) {

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(org);

		String sqlQuery = "INSERT INTO organization "
				+ "(company_name, year_of_incorporation, postal_code, employee_count, slogan) "
				+ "VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";

		// update
		int numberOfRecordsAffected = namedParameterJdbcTemplate.update(sqlQuery, parameterSource);
		return numberOfRecordsAffected == 1;
	}

	public boolean delete(Organization org) {

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(org);

		String sqlQuery = "DELETE FROM  organization WHERE id = :id ";

		// update
		int numberOfRecordsAffected = namedParameterJdbcTemplate.update(sqlQuery, parameterSource);
		return numberOfRecordsAffected == 1;
	}

	public boolean update(Organization org) {

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(org);

		String sqlQuery = "UPDATE  organization set slogan = :slogan WHERE id = :id ";

		// update
		int numberOfRecordsAffected = namedParameterJdbcTemplate.update(sqlQuery, parameterSource);
		return numberOfRecordsAffected == 1;

	}

	public void cleanup() {

		String sqlQuery = "TRUNCATE TABLE organization";

		// execute
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}
