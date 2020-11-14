package com.timbuchalka.springdemo.utils;

import org.springframework.stereotype.Component;

@Component
public class DaoUtils {

	public final String CREATE = "CREATE";
	public final String READ = "READ";
	public final String UPDATE = "UPDATE";
	public final String DELETE = "DELETE";
	public final String TRUNCATE = "TRUNCATE";

	public void printSuccessFailure(String operation, boolean param) {

		if (param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}

}
