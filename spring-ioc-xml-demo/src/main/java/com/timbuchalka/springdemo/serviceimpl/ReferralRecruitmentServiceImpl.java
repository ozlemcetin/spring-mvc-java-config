package com.timbuchalka.springdemo.serviceimpl;

import java.util.Random;

import com.timbuchalka.springdemo.service.RecruitmentService;

public class ReferralRecruitmentServiceImpl implements RecruitmentService {

	@Override
	public String recruitEmployess(String compnayName, String departmentName, int numberOfRecruitments) {

		Random random = new Random();
		String hiringFacts = compnayName + "'s " + departmentName + " hired " + random.nextInt(numberOfRecruitments)
				+ " employees which were referred to the company by employees.";
		return hiringFacts;
	}

}
