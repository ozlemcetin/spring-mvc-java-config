package com.timbuchalka.springdemo.service;

public class RandomizerServiceImplForSessionScope implements RandomizerService {

	private int randonNumber = 10;

	@Override
	public int getRandomNumber() {
		return this.randonNumber;
	}

	public void generateRandomNumber() {
		this.randonNumber = (int) (Math.random() * 99999);
	}

}
