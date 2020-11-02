package com.timbuchalka.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timbuchalka.springdemo.service.WelcomeService;

@Controller
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;

	/*
	 * http://localhost:8080/spring-mvc-demo/
	 */
	@RequestMapping("/")
	public String doWelcome(Model model) {

		// 1. Retrieving the processed data
		// WelcomeServiceImpl welcomeService = new WelcomeServiceImpl();
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Tim Buchalka");

		// 2. Add data to the model
		model.addAttribute("myWelcomeMessage", welcomeMessage);

		// 3. Return logical view name
		// Path: /WEB-INF/views/welcomeNew.jsp
		return "welcomeNew";

	}

}
