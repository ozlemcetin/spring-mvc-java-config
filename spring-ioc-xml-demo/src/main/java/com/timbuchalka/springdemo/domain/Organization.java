package com.timbuchalka.springdemo.domain;

import com.timbuchalka.springdemo.service.BusinessService;

public class Organization {

	/*
	 * Well what we can do is,
	 * 
	 * we do an inversion of control.
	 * 
	 * So that is we take away the control
	 * 
	 * of object instantiation from Cooperation
	 * 
	 * and we hand it over to an ObjectFactory.
	 * 
	 * And as an example of that would be the Spring container.
	 */

	// == fields ==
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private BusinessService businessService;

	// == constructors ==
	public Organization(String companyName_CP, int yearOfIncorpotation_CP) {
		this.companyName = companyName_CP;
		this.yearOfIncorporation = yearOfIncorpotation_CP;
	}

	// == public methods ==
	public String staticCorporateSlogan() {
		return "We build the ultimate driving machines!";
	}

	public String provideCorporateSlogan() {
		return businessService.offerService(companyName);
	}

	// == getters==
	public String getCompanyName() {
		return companyName;
	}

	// == setters ==
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", businessService="
				+ businessService + "]";
	}
}
