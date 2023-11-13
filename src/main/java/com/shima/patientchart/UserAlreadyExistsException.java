package com.shima.patientchart;

public class UserAlreadyExistsException extends RuntimeException{// 11

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
