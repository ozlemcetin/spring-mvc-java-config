package com.timbuchalka.springdemo.service;

public class RandomizerServiceImplForRequestScope implements RandomizerService {

	private int randonNumber = 5;

	@Override
	public int getRandomNumber() {
		return this.randonNumber;
	}

	public void generateRandomNumber() {
		this.randonNumber = (int) (Math.random() * 99999);
	}

}
