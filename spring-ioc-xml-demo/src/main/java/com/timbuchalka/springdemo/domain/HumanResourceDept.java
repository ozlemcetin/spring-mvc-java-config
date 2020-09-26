package com.timbuchalka.springdemo.domain;

import com.timbuchalka.springdemo.service.RecruitmentService;

public class HumanResourceDept implements Department {

	// == fields ==
	private String deptName;
	private RecruitmentService recruitmentService;
	private Organization organization;

	// == constructors ==
	public HumanResourceDept(RecruitmentService recruitmentService, Organization organization) {
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}

	// == public methods ==
	@Override
	public String hiring(int numberOfRecruitments) {
		return recruitmentService.recruitEmployess(organization.getCompanyName(), this.deptName, numberOfRecruitments);
	}

	// == setters ==
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "HumanResourceDept [deptName=" + deptName + ", recruitmentService=" + recruitmentService
				+ ", organization=" + organization + "]";
	}

}
