package com.shima.patientchart;

public class AddressAlreadyExistsException extends RuntimeException {

    public AddressAlreadyExistsException(String message) {
        super(message);
    }
}
