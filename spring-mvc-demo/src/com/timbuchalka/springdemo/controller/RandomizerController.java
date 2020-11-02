package com.timbuchalka.springdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timbuchalka.springdemo.service.RandomizerServiceImplForRequestScope;
import com.timbuchalka.springdemo.service.RandomizerServiceImplForSessionScope;

@Controller
public class RandomizerController {

	@Autowired
	private RandomizerServiceImplForRequestScope randomizerForRequestScope;

	@Autowired
	private RandomizerServiceImplForSessionScope randomizerForSessionScope;

	@RequestMapping("/randomizer")
	public void getRandom(HttpServletResponse response) throws Exception {

		response.getWriter().write("**********************  [refresh the page (f5) to see scopes behaviours] ********************** <br>");
		{
			response.getWriter().write("**********************  request scope ********************** <br>");
			response.getWriter().write("Old number: " + randomizerForRequestScope.getRandomNumber() + "<br>");

			randomizerForRequestScope.generateRandomNumber();
			response.getWriter().write("New Number: " + randomizerForRequestScope.getRandomNumber() + "<br>");
			response.getWriter().write("Object reference: " + randomizerForRequestScope + "<br>");
		}

		{
			response.getWriter().write("**********************  session scope  ********************** <br>");
			response.getWriter().write("Old number: " + randomizerForSessionScope.getRandomNumber() + "<br>");

			randomizerForSessionScope.generateRandomNumber();
			response.getWriter().write("New Number: " + randomizerForSessionScope.getRandomNumber() + "<br>");
			response.getWriter().write("Object reference: " + randomizerForSessionScope + "<br>");
		}

	}

}
