package com.fine.distribution.utlis;

import javax.validation.ValidationException;

public class HospitalException extends ValidationException {
	private static final long serialVersionUID = 1L;

	public HospitalException() {
		super();
	}

	public HospitalException(int errorCode) {
		super(String.valueOf(errorCode));
	}
}
