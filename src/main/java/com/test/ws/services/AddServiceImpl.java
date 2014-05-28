package com.test.ws.services;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl implements AddService {

	/**
	 * Returns the sum of two input numbers.
	 */
	public BigInteger addNumbers(BigInteger number1, BigInteger number2) {
		return number1.add(number2);
	}

}
