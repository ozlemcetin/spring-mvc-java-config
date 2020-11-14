package com.timbuchalka.springdemo.utils;

public class DaoUtils {

	public static final String CREATE = "CREATE";
	public static final String READ = "READ";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String TRUNCATE = "TRUNCATE";

	public static void printSuccessFailure(String operation, boolean param) {

		if (param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}

}
