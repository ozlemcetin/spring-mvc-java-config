package com.timbuchalka.springdemo.serviceimpl;

import java.util.Random;

import com.timbuchalka.springdemo.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService {

	@Override
	public String offerService(String compnayName) {

		Random random = new Random();
		String service = "As an Organization, " + compnayName + " provides an outstanding Ecommerce platform."
				+ " The annual revenue exceeds " + random.nextInt(BusinessService.revenue) + " dollars!";
		return service;
	}

}
