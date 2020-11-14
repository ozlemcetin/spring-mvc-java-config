package com.timbuchalka.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timbuchalka.springdemo.domain.Organization;
import com.timbuchalka.springdemo.service.OrganizationService;

@Controller
public class OrganizationController {

	private final OrganizationService organizationService;

	@Autowired
	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@RequestMapping("/jstlsql")
	public String getOrganizationUsingSQLTag() {

		return "listOrganizationUsingSql";
	}

	@RequestMapping("/service")
	public String getOrganizationUsingService(Model model) {

		List<Organization> orgList = organizationService.getOrgList();
		model.addAttribute("orgList", orgList);

		return "listOrganizationUsingService";
	}

}
