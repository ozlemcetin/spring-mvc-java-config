package com.timbuchalka.springdemo.serviceimpl;

import java.util.Random;

import com.timbuchalka.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String compnayName) {

		Random random = new Random();
		String service = "As an Organization, " + compnayName + " offers world class Cloud Computing infrastructure."
				+ " The annual income exceeds " + random.nextInt(BusinessService.revenue) + " dollars!";
		return service;
	}

}
